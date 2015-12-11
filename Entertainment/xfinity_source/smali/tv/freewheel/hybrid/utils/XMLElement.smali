.class public Ltv/freewheel/hybrid/utils/XMLElement;
.super Ljava/lang/Object;
.source "XMLElement.java"


# instance fields
.field private attributes:Ljava/util/TreeMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/TreeMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private children:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/utils/XMLElement;",
            ">;"
        }
    .end annotation
.end field

.field private isCDATASection:Z

.field private name:Ljava/lang/String;

.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/utils/XMLElement;->isCDATASection:Z

    .line 24
    iput-object p1, p0, Ltv/freewheel/hybrid/utils/XMLElement;->name:Ljava/lang/String;

    .line 25
    new-instance v0, Ljava/util/TreeMap;

    invoke-direct {v0}, Ljava/util/TreeMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/XMLElement;->attributes:Ljava/util/TreeMap;

    .line 26
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/XMLElement;->children:Ljava/util/ArrayList;

    .line 27
    return-void
.end method


# virtual methods
.method public appendChild(Ltv/freewheel/hybrid/utils/XMLElement;)V
    .locals 1
    .param p1, "child"    # Ltv/freewheel/hybrid/utils/XMLElement;

    .prologue
    .line 98
    if-eqz p1, :cond_0

    .line 99
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/XMLElement;->children:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 101
    :cond_0
    return-void
.end method

.method public setAttribute(Ljava/lang/String;D)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # D

    .prologue
    .line 78
    invoke-static {p2, p3}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 79
    return-void
.end method

.method public setAttribute(Ljava/lang/String;DZ)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # D
    .param p4, "validate"    # Z

    .prologue
    .line 82
    if-eqz p4, :cond_0

    const-wide/16 v0, 0x0

    cmpg-double v0, p2, v0

    if-gtz v0, :cond_0

    .line 86
    :goto_0
    return-void

    .line 85
    :cond_0
    invoke-virtual {p0, p1, p2, p3}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;D)V

    goto :goto_0
.end method

.method public setAttribute(Ljava/lang/String;I)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 63
    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    return-void
.end method

.method public setAttribute(Ljava/lang/String;IZ)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # I
    .param p3, "validate"    # Z

    .prologue
    .line 67
    if-eqz p3, :cond_0

    if-gtz p2, :cond_0

    .line 71
    :goto_0
    return-void

    .line 70
    :cond_0
    invoke-virtual {p0, p1, p2}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method public setAttribute(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 53
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 60
    :cond_0
    :goto_0
    return-void

    .line 56
    :cond_1
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/XMLElement;->attributes:Ljava/util/TreeMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public setAttribute(Ljava/lang/String;Z)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 74
    invoke-static {p2}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Ltv/freewheel/hybrid/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    return-void
.end method

.method public setText(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 89
    iput-object p1, p0, Ltv/freewheel/hybrid/utils/XMLElement;->value:Ljava/lang/String;

    .line 90
    return-void
.end method

.method public toXML(Lorg/xmlpull/v1/XmlSerializer;)V
    .locals 5
    .param p1, "serializer"    # Lorg/xmlpull/v1/XmlSerializer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 104
    const-string v3, ""

    iget-object v4, p0, Ltv/freewheel/hybrid/utils/XMLElement;->name:Ljava/lang/String;

    invoke-interface {p1, v3, v4}, Lorg/xmlpull/v1/XmlSerializer;->startTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    .line 105
    iget-object v3, p0, Ltv/freewheel/hybrid/utils/XMLElement;->attributes:Ljava/util/TreeMap;

    invoke-virtual {v3}, Ljava/util/TreeMap;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 106
    .local v2, "s_iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 107
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 108
    .local v0, "key":Ljava/lang/String;
    const-string v4, ""

    iget-object v3, p0, Ltv/freewheel/hybrid/utils/XMLElement;->attributes:Ljava/util/TreeMap;

    invoke-virtual {v3, v0}, Ljava/util/TreeMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {p1, v4, v0, v3}, Lorg/xmlpull/v1/XmlSerializer;->attribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    goto :goto_0

    .line 111
    .end local v0    # "key":Ljava/lang/String;
    :cond_0
    iget-object v3, p0, Ltv/freewheel/hybrid/utils/XMLElement;->value:Ljava/lang/String;

    if-eqz v3, :cond_1

    .line 112
    iget-boolean v3, p0, Ltv/freewheel/hybrid/utils/XMLElement;->isCDATASection:Z

    if-eqz v3, :cond_2

    .line 113
    iget-object v3, p0, Ltv/freewheel/hybrid/utils/XMLElement;->value:Ljava/lang/String;

    invoke-interface {p1, v3}, Lorg/xmlpull/v1/XmlSerializer;->cdsect(Ljava/lang/String;)V

    .line 119
    :cond_1
    :goto_1
    iget-object v3, p0, Ltv/freewheel/hybrid/utils/XMLElement;->children:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 120
    .local v1, "o_iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/utils/XMLElement;>;"
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 121
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ltv/freewheel/hybrid/utils/XMLElement;

    invoke-virtual {v3, p1}, Ltv/freewheel/hybrid/utils/XMLElement;->toXML(Lorg/xmlpull/v1/XmlSerializer;)V

    goto :goto_2

    .line 115
    .end local v1    # "o_iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/utils/XMLElement;>;"
    :cond_2
    iget-object v3, p0, Ltv/freewheel/hybrid/utils/XMLElement;->value:Ljava/lang/String;

    invoke-interface {p1, v3}, Lorg/xmlpull/v1/XmlSerializer;->text(Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    goto :goto_1

    .line 123
    .restart local v1    # "o_iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/utils/XMLElement;>;"
    :cond_3
    const-string v3, ""

    iget-object v4, p0, Ltv/freewheel/hybrid/utils/XMLElement;->name:Ljava/lang/String;

    invoke-interface {p1, v3, v4}, Lorg/xmlpull/v1/XmlSerializer;->endTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    .line 124
    return-void
.end method
