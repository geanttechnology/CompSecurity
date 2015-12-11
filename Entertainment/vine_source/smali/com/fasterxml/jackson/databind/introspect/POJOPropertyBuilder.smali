.class public Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;
.super Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;
.source "POJOPropertyBuilder.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;,
        Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$WithMember;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;",
        ">;"
    }
.end annotation


# instance fields
.field protected final _annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

.field protected _ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;",
            ">;"
        }
    .end annotation
.end field

.field protected _fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;",
            ">;"
        }
    .end annotation
.end field

.field protected final _forSerialization:Z

.field protected _getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;",
            ">;"
        }
    .end annotation
.end field

.field protected final _internalName:Lcom/fasterxml/jackson/databind/PropertyName;

.field protected final _name:Lcom/fasterxml/jackson/databind/PropertyName;

.field protected _setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/PropertyName;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;Z)V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;-><init>()V

    .line 48
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_internalName:Lcom/fasterxml/jackson/databind/PropertyName;

    .line 49
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_name:Lcom/fasterxml/jackson/databind/PropertyName;

    .line 50
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    .line 51
    iput-boolean p3, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_forSerialization:Z

    .line 52
    return-void
.end method

.method public constructor <init>(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;Lcom/fasterxml/jackson/databind/PropertyName;)V
    .locals 1

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;-><init>()V

    .line 63
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_internalName:Lcom/fasterxml/jackson/databind/PropertyName;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_internalName:Lcom/fasterxml/jackson/databind/PropertyName;

    .line 64
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_name:Lcom/fasterxml/jackson/databind/PropertyName;

    .line 65
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    .line 66
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 67
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 68
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 69
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 70
    iget-boolean v0, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_forSerialization:Z

    iput-boolean v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_forSerialization:Z

    .line 71
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;Z)V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 58
    new-instance v0, Lcom/fasterxml/jackson/databind/PropertyName;

    invoke-direct {v0, p1}, Lcom/fasterxml/jackson/databind/PropertyName;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v0, p2, p3}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;-><init>(Lcom/fasterxml/jackson/databind/PropertyName;Lcom/fasterxml/jackson/databind/AnnotationIntrospector;Z)V

    .line 59
    return-void
.end method

.method private _anyExplicitNames(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<TT;>;)Z"
        }
    .end annotation

    .prologue
    .line 618
    :goto_0
    if-eqz p1, :cond_1

    .line 619
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->explicitName:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->explicitName:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 620
    const/4 v0, 0x1

    .line 623
    :goto_1
    return v0

    .line 618
    :cond_0
    iget-object p1, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->next:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    goto :goto_0

    .line 623
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private _anyIgnorals(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<TT;>;)Z"
        }
    .end annotation

    .prologue
    .line 654
    :goto_0
    if-eqz p1, :cond_1

    .line 655
    iget-boolean v0, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->isMarkedIgnored:Z

    if-eqz v0, :cond_0

    .line 656
    const/4 v0, 0x1

    .line 659
    :goto_1
    return v0

    .line 654
    :cond_0
    iget-object p1, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->next:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    goto :goto_0

    .line 659
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private _anyVisible(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<TT;>;)Z"
        }
    .end annotation

    .prologue
    .line 636
    :goto_0
    if-eqz p1, :cond_1

    .line 637
    iget-boolean v0, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->isVisible:Z

    if-eqz v0, :cond_0

    .line 638
    const/4 v0, 0x1

    .line 641
    :goto_1
    return v0

    .line 636
    :cond_0
    iget-object p1, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->next:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    goto :goto_0

    .line 641
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private varargs _mergeAnnotations(I[Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I[",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<+",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;",
            ">;)",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;"
        }
    .end annotation

    .prologue
    .line 576
    aget-object v0, p2, p1

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;->getAllAnnotations()Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;

    move-result-object v1

    .line 577
    add-int/lit8 v0, p1, 0x1

    .line 578
    :goto_0
    array-length v2, p2

    if-ge v0, v2, :cond_1

    .line 579
    aget-object v2, p2, v0

    if-eqz v2, :cond_0

    .line 580
    invoke-direct {p0, v0, p2}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_mergeAnnotations(I[Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;->merge(Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;)Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;

    move-result-object v0

    .line 583
    :goto_1
    return-object v0

    .line 578
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    move-object v0, v1

    .line 583
    goto :goto_1
.end method

.method private _removeIgnored(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<TT;>;)",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 588
    if-nez p1, :cond_0

    .line 591
    :goto_0
    return-object p1

    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->withoutIgnored()Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object p1

    goto :goto_0
.end method

.method private _removeNonVisible(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<TT;>;)",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 596
    if-nez p1, :cond_0

    .line 599
    :goto_0
    return-object p1

    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->withoutNonVisible()Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object p1

    goto :goto_0
.end method

.method private _trimByVisibility(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<TT;>;)",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 604
    if-nez p1, :cond_0

    .line 607
    :goto_0
    return-object p1

    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->trimByVisibility()Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object p1

    goto :goto_0
.end method

.method private findRenamed(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<+",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;",
            ">;",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<+",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;",
            ">;)",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<+",
            "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;",
            ">;"
        }
    .end annotation

    .prologue
    .line 680
    move-object v0, p2

    move-object v1, p1

    :goto_0
    if-eqz v1, :cond_3

    .line 681
    iget-object v2, v1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->explicitName:Ljava/lang/String;

    .line 682
    if-nez v2, :cond_1

    .line 680
    :cond_0
    :goto_1
    iget-object v1, v1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->next:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    goto :goto_0

    .line 686
    :cond_1
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_name:Lcom/fasterxml/jackson/databind/PropertyName;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 689
    if-nez v0, :cond_2

    move-object v0, v1

    .line 690
    goto :goto_1

    .line 693
    :cond_2
    iget-object v3, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->explicitName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 694
    new-instance v2, Ljava/lang/IllegalStateException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Conflicting property name definitions: \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->explicitName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\' (for "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, ") vs \'"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v3, v1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->explicitName:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "\' (for "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 700
    :cond_3
    return-object v0
.end method

.method private static merge(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<TT;>;",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<TT;>;)",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 480
    if-nez p0, :cond_0

    .line 486
    :goto_0
    return-object p1

    .line 483
    :cond_0
    if-nez p1, :cond_1

    move-object p1, p0

    .line 484
    goto :goto_0

    .line 486
    :cond_1
    # invokes: Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->append(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;
    invoke-static {p0, p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->access$000(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object p1

    goto :goto_0
.end method


# virtual methods
.method protected _findDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 422
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$5;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$5;-><init>(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;)V

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->fromMemberAnnotations(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$WithMember;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method protected _findRequired()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 412
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$4;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$4;-><init>(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;)V

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->fromMemberAnnotations(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$WithMember;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 418
    return-object v0
.end method

.method public addAll(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;)V
    .locals 2

    .prologue
    .line 472
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v1, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-static {v0, v1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->merge(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 473
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v1, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-static {v0, v1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->merge(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 474
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v1, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-static {v0, v1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->merge(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 475
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v1, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-static {v0, v1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->merge(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 476
    return-void
.end method

.method public addCtor(Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;Ljava/lang/String;ZZ)V
    .locals 6

    .prologue
    .line 455
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-object v1, p1

    move-object v3, p2

    move v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;-><init>(Ljava/lang/Object;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Ljava/lang/String;ZZ)V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 456
    return-void
.end method

.method public addField(Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;Ljava/lang/String;ZZ)V
    .locals 6

    .prologue
    .line 451
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-object v1, p1

    move-object v3, p2

    move v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;-><init>(Ljava/lang/Object;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Ljava/lang/String;ZZ)V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 452
    return-void
.end method

.method public addGetter(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;Ljava/lang/String;ZZ)V
    .locals 6

    .prologue
    .line 459
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-object v1, p1

    move-object v3, p2

    move v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;-><init>(Ljava/lang/Object;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Ljava/lang/String;ZZ)V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 460
    return-void
.end method

.method public addSetter(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;Ljava/lang/String;ZZ)V
    .locals 6

    .prologue
    .line 463
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-object v1, p1

    move-object v3, p2

    move v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;-><init>(Ljava/lang/Object;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Ljava/lang/String;ZZ)V

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 464
    return-void
.end method

.method public anyIgnorals()Z
    .locals 1

    .prologue
    .line 645
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_anyIgnorals(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_anyIgnorals(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_anyIgnorals(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_anyIgnorals(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public anyVisible()Z
    .locals 1

    .prologue
    .line 627
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_anyVisible(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_anyVisible(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_anyVisible(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_anyVisible(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public compareTo(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;)I
    .locals 2

    .prologue
    .line 109
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v0, :cond_0

    .line 110
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-nez v0, :cond_1

    .line 111
    const/4 v0, -0x1

    .line 119
    :goto_0
    return v0

    .line 113
    :cond_0
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v0, :cond_1

    .line 114
    const/4 v0, 0x1

    goto :goto_0

    .line 119
    :cond_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 12
    check-cast p1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;

    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->compareTo(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;)I

    move-result v0

    return v0
.end method

.method public couldSerialize()Z
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public findNewName()Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 669
    .line 670
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v1, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->findRenamed(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v1

    .line 671
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v2, v1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->findRenamed(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v1

    .line 672
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v2, v1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->findRenamed(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v1

    .line 673
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v2, v1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->findRenamed(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v1

    .line 674
    if-nez v1, :cond_0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, v1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->explicitName:Ljava/lang/String;

    goto :goto_0
.end method

.method public findObjectIdInfo()Lcom/fasterxml/jackson/databind/introspect/ObjectIdInfo;
    .locals 1

    .prologue
    .line 432
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$6;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$6;-><init>(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;)V

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->fromMemberAnnotations(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$WithMember;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/ObjectIdInfo;

    return-object v0
.end method

.method public findReferenceType()Lcom/fasterxml/jackson/databind/AnnotationIntrospector$ReferenceProperty;
    .locals 1

    .prologue
    .line 381
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$2;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$2;-><init>(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;)V

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->fromMemberAnnotations(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$WithMember;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/fasterxml/jackson/databind/AnnotationIntrospector$ReferenceProperty;

    return-object v0
.end method

.method public findViews()[Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()[",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 371
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$1;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$1;-><init>(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;)V

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->fromMemberAnnotations(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$WithMember;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/Class;

    return-object v0
.end method

.method protected fromMemberAnnotations(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$WithMember;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$WithMember",
            "<TT;>;)TT;"
        }
    .end annotation

    .prologue
    .line 730
    const/4 v0, 0x0

    .line 731
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    if-eqz v1, :cond_1

    .line 732
    iget-boolean v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_forSerialization:Z

    if-eqz v1, :cond_2

    .line 733
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v1, :cond_0

    .line 734
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    invoke-interface {p1, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$WithMember;->withMember(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Ljava/lang/Object;

    move-result-object v0

    .line 744
    :cond_0
    :goto_0
    if-nez v0, :cond_1

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v1, :cond_1

    .line 745
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    invoke-interface {p1, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$WithMember;->withMember(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Ljava/lang/Object;

    move-result-object v0

    .line 748
    :cond_1
    return-object v0

    .line 737
    :cond_2
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v1, :cond_3

    .line 738
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    invoke-interface {p1, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$WithMember;->withMember(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Ljava/lang/Object;

    move-result-object v0

    .line 740
    :cond_3
    if-nez v0, :cond_0

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v1, :cond_0

    .line 741
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    invoke-interface {p1, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$WithMember;->withMember(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public getAccessor()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    .locals 1

    .prologue
    .line 326
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getGetter()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    move-result-object v0

    .line 327
    if-nez v0, :cond_0

    .line 328
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getField()Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;

    move-result-object v0

    .line 330
    :cond_0
    return-object v0
.end method

.method public getConstructorParameter()Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;
    .locals 2

    .prologue
    .line 302
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-nez v0, :cond_0

    .line 303
    const/4 v0, 0x0

    .line 320
    :goto_0
    return-object v0

    .line 313
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-object v1, v0

    .line 315
    :goto_1
    iget-object v0, v1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;->getOwner()Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;

    move-result-object v0

    instance-of v0, v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;

    if-eqz v0, :cond_1

    .line 316
    iget-object v0, v1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    goto :goto_0

    .line 318
    :cond_1
    iget-object v0, v1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->next:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 319
    if-nez v0, :cond_2

    .line 320
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    goto :goto_0

    :cond_2
    move-object v1, v0

    goto :goto_1
.end method

.method public getField()Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;
    .locals 6

    .prologue
    .line 274
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-nez v0, :cond_1

    .line 275
    const/4 v1, 0x0

    .line 296
    :cond_0
    return-object v1

    .line 278
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;

    .line 279
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->next:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-object v2, v1

    move-object v1, v0

    .line 280
    :goto_0
    if-eqz v2, :cond_0

    .line 281
    iget-object v0, v2, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;

    .line 282
    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;->getDeclaringClass()Ljava/lang/Class;

    move-result-object v3

    .line 283
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;->getDeclaringClass()Ljava/lang/Class;

    move-result-object v4

    .line 284
    if-eq v3, v4, :cond_3

    .line 285
    invoke-virtual {v3, v4}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 280
    :goto_1
    iget-object v1, v2, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->next:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-object v2, v1

    move-object v1, v0

    goto :goto_0

    .line 289
    :cond_2
    invoke-virtual {v4, v3}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v3

    if-eqz v3, :cond_3

    move-object v0, v1

    .line 290
    goto :goto_1

    .line 293
    :cond_3
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Multiple fields representing property \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\": "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;->getFullName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " vs "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;->getFullName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public getFullName()Lcom/fasterxml/jackson/databind/PropertyName;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_name:Lcom/fasterxml/jackson/databind/PropertyName;

    return-object v0
.end method

.method public getGetter()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    .locals 8

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 196
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-nez v0, :cond_1

    .line 197
    const/4 v4, 0x0

    .line 236
    :cond_0
    return-object v4

    .line 200
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    .line 201
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->next:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-object v6, v1

    move-object v4, v0

    .line 202
    :goto_0
    if-eqz v6, :cond_0

    .line 207
    iget-object v0, v6, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    .line 208
    invoke-virtual {v4}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getDeclaringClass()Ljava/lang/Class;

    move-result-object v1

    .line 209
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getDeclaringClass()Ljava/lang/Class;

    move-result-object v5

    .line 210
    if-eq v1, v5, :cond_4

    .line 211
    invoke-virtual {v1, v5}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 202
    :cond_2
    :goto_1
    iget-object v1, v6, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->next:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-object v6, v1

    move-object v4, v0

    goto :goto_0

    .line 215
    :cond_3
    invoke-virtual {v5, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v1

    if-eqz v1, :cond_4

    move-object v0, v4

    .line 216
    goto :goto_1

    .line 224
    :cond_4
    invoke-virtual {v4}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v4, v1}, Lcom/fasterxml/jackson/databind/util/BeanUtil;->okNameForIsGetter(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_5

    move v1, v2

    .line 225
    :goto_2
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-static {v0, v5}, Lcom/fasterxml/jackson/databind/util/BeanUtil;->okNameForIsGetter(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_6

    move v5, v2

    .line 227
    :goto_3
    if-eq v1, v5, :cond_7

    .line 228
    if-nez v1, :cond_2

    move-object v0, v4

    goto :goto_1

    :cond_5
    move v1, v3

    .line 224
    goto :goto_2

    :cond_6
    move v5, v3

    .line 225
    goto :goto_3

    .line 233
    :cond_7
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Conflicting getter definitions for property \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\": "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v4}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getFullName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " vs "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getFullName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public getInternalName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_internalName:Lcom/fasterxml/jackson/databind/PropertyName;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/PropertyName;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMetadata()Lcom/fasterxml/jackson/databind/PropertyMetadata;
    .locals 2

    .prologue
    .line 402
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_findRequired()Ljava/lang/Boolean;

    move-result-object v0

    .line 403
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_findDescription()Ljava/lang/String;

    move-result-object v1

    .line 404
    if-nez v0, :cond_1

    .line 405
    if-nez v1, :cond_0

    sget-object v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->STD_REQUIRED_OR_OPTIONAL:Lcom/fasterxml/jackson/databind/PropertyMetadata;

    .line 408
    :goto_0
    return-object v0

    .line 405
    :cond_0
    sget-object v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->STD_REQUIRED_OR_OPTIONAL:Lcom/fasterxml/jackson/databind/PropertyMetadata;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/PropertyMetadata;->withDescription(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/PropertyMetadata;

    move-result-object v0

    goto :goto_0

    .line 408
    :cond_1
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_findDescription()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/fasterxml/jackson/databind/PropertyMetadata;->construct(ZLjava/lang/String;)Lcom/fasterxml/jackson/databind/PropertyMetadata;

    move-result-object v0

    goto :goto_0
.end method

.method public getMutator()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    .locals 1

    .prologue
    .line 336
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getConstructorParameter()Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    move-result-object v0

    .line 337
    if-nez v0, :cond_0

    .line 338
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getSetter()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    move-result-object v0

    .line 339
    if-nez v0, :cond_0

    .line 340
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getField()Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;

    move-result-object v0

    .line 343
    :cond_0
    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_name:Lcom/fasterxml/jackson/databind/PropertyName;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_name:Lcom/fasterxml/jackson/databind/PropertyName;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/PropertyName;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getNonConstructorMutator()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    .locals 1

    .prologue
    .line 348
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getSetter()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    move-result-object v0

    .line 349
    if-nez v0, :cond_0

    .line 350
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getField()Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;

    move-result-object v0

    .line 352
    :cond_0
    return-object v0
.end method

.method public getPrimaryMember()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;
    .locals 1

    .prologue
    .line 357
    iget-boolean v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_forSerialization:Z

    if-eqz v0, :cond_0

    .line 358
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getAccessor()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    move-result-object v0

    .line 360
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getMutator()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    move-result-object v0

    goto :goto_0
.end method

.method public getSetter()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;
    .locals 6

    .prologue
    .line 242
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-nez v0, :cond_1

    .line 243
    const/4 v1, 0x0

    .line 268
    :cond_0
    return-object v1

    .line 246
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    .line 247
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v1, v1, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->next:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-object v2, v1

    move-object v1, v0

    .line 248
    :goto_0
    if-eqz v2, :cond_0

    .line 253
    iget-object v0, v2, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    .line 254
    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getDeclaringClass()Ljava/lang/Class;

    move-result-object v3

    .line 255
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getDeclaringClass()Ljava/lang/Class;

    move-result-object v4

    .line 256
    if-eq v3, v4, :cond_3

    .line 257
    invoke-virtual {v3, v4}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 248
    :goto_1
    iget-object v1, v2, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->next:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-object v2, v1

    move-object v1, v0

    goto :goto_0

    .line 261
    :cond_2
    invoke-virtual {v4, v3}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v3

    if-eqz v3, :cond_3

    move-object v0, v1

    .line 262
    goto :goto_1

    .line 265
    :cond_3
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Conflicting setter definitions for property \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\": "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getFullName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " vs "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->getFullName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public getWrapperName()Lcom/fasterxml/jackson/databind/PropertyName;
    .locals 2

    .prologue
    .line 148
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->getPrimaryMember()Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;

    move-result-object v0

    .line 149
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    if-nez v1, :cond_1

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_1
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_annotationIntrospector:Lcom/fasterxml/jackson/databind/AnnotationIntrospector;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/databind/AnnotationIntrospector;->findWrapperName(Lcom/fasterxml/jackson/databind/introspect/Annotated;)Lcom/fasterxml/jackson/databind/PropertyName;

    move-result-object v0

    goto :goto_0
.end method

.method public hasConstructorParameter()Z
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasField()Z
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasGetter()Z
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasSetter()Z
    .locals 1

    .prologue
    .line 180
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isExplicitlyIncluded()Z
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_anyExplicitNames(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_anyExplicitNames(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_anyExplicitNames(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_anyExplicitNames(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isTypeId()Z
    .locals 1

    .prologue
    .line 391
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$3;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$3;-><init>(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;)V

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->fromMemberAnnotations(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$WithMember;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 397
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public mergeAnnotations(Z)V
    .locals 6

    .prologue
    const/4 v1, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 552
    if-eqz p1, :cond_2

    .line 553
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v0, :cond_1

    .line 554
    new-array v0, v1, [Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v3

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v4

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v5

    invoke-direct {p0, v2, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_mergeAnnotations(I[Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;

    move-result-object v1

    .line 555
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->withAnnotations(Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->withValue(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 572
    :cond_0
    :goto_0
    return-void

    .line 556
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v0, :cond_0

    .line 557
    new-array v0, v5, [Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v3

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v4

    invoke-direct {p0, v2, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_mergeAnnotations(I[Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;

    move-result-object v1

    .line 558
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;->withAnnotations(Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->withValue(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    goto :goto_0

    .line 561
    :cond_2
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v0, :cond_3

    .line 562
    new-array v0, v1, [Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v3

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v4

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v5

    invoke-direct {p0, v2, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_mergeAnnotations(I[Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;

    move-result-object v1

    .line 563
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;->withAnnotations(Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->withValue(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    goto :goto_0

    .line 564
    :cond_3
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v0, :cond_4

    .line 565
    new-array v0, v5, [Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v3

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v4

    invoke-direct {p0, v2, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_mergeAnnotations(I[Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;

    move-result-object v1

    .line 566
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;->withAnnotations(Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->withValue(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    goto :goto_0

    .line 567
    :cond_4
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-eqz v0, :cond_0

    .line 568
    new-array v0, v4, [Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    aput-object v1, v0, v3

    invoke-direct {p0, v2, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_mergeAnnotations(I[Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;

    move-result-object v1

    .line 569
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    iget-object v0, v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->value:Ljava/lang/Object;

    check-cast v0, Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;

    invoke-virtual {v0, v1}, Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;->withAnnotations(Lcom/fasterxml/jackson/databind/introspect/AnnotationMap;)Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;->withValue(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    goto/16 :goto_0
.end method

.method public removeIgnored()V
    .locals 1

    .prologue
    .line 501
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_removeIgnored(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 502
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_removeIgnored(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 503
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_removeIgnored(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 504
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_removeIgnored(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 505
    return-void
.end method

.method public removeNonVisible()V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 512
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->removeNonVisible(Z)V

    .line 513
    return-void
.end method

.method public removeNonVisible(Z)V
    .locals 1

    .prologue
    .line 527
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_removeNonVisible(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 528
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_removeNonVisible(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 530
    if-nez p1, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    if-nez v0, :cond_1

    .line 531
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_removeNonVisible(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 532
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_removeNonVisible(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 534
    :cond_1
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 707
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 708
    const-string v1, "[Property \'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_name:Lcom/fasterxml/jackson/databind/PropertyName;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\'; ctors: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", field(s): "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", getter(s): "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", setter(s): "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 714
    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 715
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public trimByVisibility()V
    .locals 1

    .prologue
    .line 543
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_trimByVisibility(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_fields:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 544
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_trimByVisibility(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_getters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 545
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_trimByVisibility(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_setters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 546
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_trimByVisibility(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    move-result-object v0

    iput-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_ctorParameters:Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked;

    .line 547
    return-void
.end method

.method public bridge synthetic withName(Lcom/fasterxml/jackson/databind/PropertyName;)Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;
    .locals 1

    .prologue
    .line 12
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->withName(Lcom/fasterxml/jackson/databind/PropertyName;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic withName(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;
    .locals 1

    .prologue
    .line 12
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->withName(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;

    move-result-object v0

    return-object v0
.end method

.method public withName(Lcom/fasterxml/jackson/databind/PropertyName;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;
    .locals 1

    .prologue
    .line 87
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;

    invoke-direct {v0, p0, p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;-><init>(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;Lcom/fasterxml/jackson/databind/PropertyName;)V

    return-object v0
.end method

.method public withName(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 82
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->withSimpleName(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic withSimpleName(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/BeanPropertyDefinition;
    .locals 1

    .prologue
    .line 12
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->withSimpleName(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;

    move-result-object v0

    return-object v0
.end method

.method public withSimpleName(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;
    .locals 2

    .prologue
    .line 93
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_name:Lcom/fasterxml/jackson/databind/PropertyName;

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/PropertyName;->withSimpleName(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/PropertyName;

    move-result-object v1

    .line 94
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;->_name:Lcom/fasterxml/jackson/databind/PropertyName;

    if-ne v1, v0, :cond_0

    :goto_0
    return-object p0

    :cond_0
    new-instance v0, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;

    invoke-direct {v0, p0, v1}, Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;-><init>(Lcom/fasterxml/jackson/databind/introspect/POJOPropertyBuilder;Lcom/fasterxml/jackson/databind/PropertyName;)V

    move-object p0, v0

    goto :goto_0
.end method
