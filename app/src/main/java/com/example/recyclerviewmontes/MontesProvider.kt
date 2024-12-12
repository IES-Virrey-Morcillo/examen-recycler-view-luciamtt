package com.example.recyclerviewmontes

class MontesProvider {
    companion object {
        val montesList = listOf(
            Montes(
                nombre = "Mulhacén",
                altura = "3482",
                continente = "Europa",
                foto = "https://ullerco.com/cdn/shop/articles/mulhacen-b8badd05-1783-44b9-becd-a603cbfbf5f3.jpg?v=1647448449"
            ),
            Montes(
                nombre = "Kilimanjaro",
                altura = "5895",
                continente = "África",
                foto = "https://static.nationalgeographic.es/files/styles/image_3200/public/zebras-kilimanjaro-africa.webp?w=1279&h=720"
            ),
            Montes(
                nombre = "Everest",
                altura = "8849",
                continente = "Asia",
                foto = "https://static.nationalgeographic.es/files/styles/image_3200/public/everest-book-talk-climbers.webp?w=1279&h=720"
            )
        )
    }
}
