package com.SIT.codeDR.models;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.JoinColumn;
import javax.persistence.Embeddable;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;


@Embeddable
class TeachKey implements Serializable {
    @Column(name = "module_id")
    private Long moduleId;

    @Column(name = "user_id")
    private Long userId;
}

@Entity
public class Teach{
    @EmbeddedId
    TeachKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("moduleId")
    @JoinColumn(name = "module_id")
    private Module module;

    @Column
    private boolean creator;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "permission_id", referencedColumnName = "id")
    private Permission permission;


}
