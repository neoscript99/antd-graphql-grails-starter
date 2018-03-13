package neo.script.grails.graphql.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor
import neo.script.gorm.data.initializer.initialize.InitializeDomian

@TupleConstructor
@ToString(includePackage = false, includes = 'name,dept')
@EqualsAndHashCode(includes = 'account')
@InitializeDomian(depends = [Department])
class User {
    static final User ADMIN = (new User(account: 'admin', name: '系统管理员', dept: Department.HEAD_OFFICE,
            editable: false, password: EncoderUtil.md5('admin')))
    static final User ANONYMOUS = (new User(account: 'anonymous', name: '匿名帐号', dept: Department.HEAD_OFFICE,
            editable: false, password: EncoderUtil.md5('anonymous')))

    String account
    String password
    String name
    Boolean editable = true
    Boolean enabled = true
    Department dept;
    static mapping = {
        dept fetch: 'join', lazy: false
    }
    static constraints = { account unique: true }

    static final initList = [ADMIN, ANONYMOUS]
}
