package neo.script.grails.graphql.demo

import neo.script.gorm.data.initializer.initialize.InitializeDomian

@InitializeDomian(depends = Speaker)
class Talk {

    String id
    String title
    int duration

    static graphql = true // <1>

    static belongsTo = [speaker: Speaker]

    static constraints = {
        title nullable: true, maxSize: 128
    }
    static initList = [
            new Talk(title: 'Testing with Grails 3', duration: 90, speaker: Speaker.JEFF)
            , new Talk(title: 'Polyglot Development with Grails 3', duration: 90, speaker: Speaker.JEFF)
            , new Talk(title: 'GORM Deep Dive', duration: 120, speaker: Speaker.GRAEME)
            , new Talk(title: "What's New in Grails 4", duration: 60, speaker: Speaker.GRAEME)
            , new Talk(title: 'Grails in the Wonderful World of JavaScript Frameworks', duration: 90, speaker: Speaker.ZAK)]
}