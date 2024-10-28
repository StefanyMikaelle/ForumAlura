package br.com.stefany.forum.mapper

interface Mapper<T, U> {
    fun map (t: T) : U
}
