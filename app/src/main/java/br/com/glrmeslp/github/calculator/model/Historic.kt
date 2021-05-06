package br.com.glrmeslp.github.calculator.model

class Historic(var result: String) {
    
    companion object{
        var listHistoric: MutableList<Historic> = mutableListOf()
    }

    init {
        listHistoric.add(this)
    }
    
}
