.class public Lcom/comcast/cim/microdata/model/MissingMicrodataProperty;
.super Ljava/lang/Object;
.source "MissingMicrodataProperty.java"

# interfaces
.implements Lcom/comcast/cim/microdata/model/MicrodataProperty;


# instance fields
.field private name:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MissingMicrodataProperty;->name:Ljava/lang/String;

    .line 17
    return-void
.end method


# virtual methods
.method public asBoolean()Ljava/lang/Boolean;
    .locals 3

    .prologue
    .line 56
    new-instance v0, Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not find property "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MissingMicrodataProperty;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public asBoolean(Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0
    .param p1, "defaultValue"    # Ljava/lang/Boolean;

    .prologue
    .line 81
    return-object p1
.end method

.method public asInt()Ljava/lang/Integer;
    .locals 3

    .prologue
    .line 61
    new-instance v0, Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not find property "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MissingMicrodataProperty;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public asInt(Ljava/lang/Integer;)Ljava/lang/Integer;
    .locals 0
    .param p1, "defaultValue"    # Ljava/lang/Integer;

    .prologue
    .line 86
    return-object p1
.end method

.method public asItem()Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 3

    .prologue
    .line 101
    new-instance v0, Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not find property "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MissingMicrodataProperty;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public asItems()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 106
    new-instance v0, Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not find property "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MissingMicrodataProperty;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public asLink()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
    .locals 3

    .prologue
    .line 111
    new-instance v0, Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not find property "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MissingMicrodataProperty;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public asList()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 71
    new-instance v0, Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not find property "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MissingMicrodataProperty;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public asList(Ljava/util/List;)Ljava/util/List;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 96
    .local p1, "defaultValue":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    return-object p1
.end method

.method public asString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 51
    new-instance v0, Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not find property "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MissingMicrodataProperty;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public asString(Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p1, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 76
    return-object p1
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MissingMicrodataProperty;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 21
    const/4 v0, 0x0

    return-object v0
.end method

.method public getValues()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 26
    const/4 v0, 0x0

    return-object v0
.end method

.method public isCollection()Z
    .locals 1

    .prologue
    .line 46
    const/4 v0, 0x0

    return v0
.end method

.method public isEmbedded()Z
    .locals 1

    .prologue
    .line 41
    const/4 v0, 0x0

    return v0
.end method

.method public isMissing()Z
    .locals 1

    .prologue
    .line 131
    const/4 v0, 0x1

    return v0
.end method
