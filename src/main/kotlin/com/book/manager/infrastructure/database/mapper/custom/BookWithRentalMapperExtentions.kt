package com.book.manager.infrastructure.database.mapper.custom

import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.book
import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.author
import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.id
import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.releaseDate
import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.title
import com.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.rental
import com.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.rentalDatetime
import com.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.returnDeadline
import com.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.userId
import com.book.manager.infrastructure.database.record.custom.BookWithRentalRecord
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select


private val columnList = listOf(
    id,
    title,
    author,
    releaseDate,
    userId,
    rentalDatetime,
    returnDeadline
)

fun BookWithRentalMapper.select(): List<BookWithRentalRecord> {
    val selectStatement = select(columnList) {
        from(book, "b")
        leftJoin(rental) {
            on(rental.bookId) equalTo book.id
        }
    }
    return selectMany(selectStatement)
}