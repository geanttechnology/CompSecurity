.class public Lcom/comcast/cim/microdata/model/MicrodataFormImpl;
.super Ljava/lang/Object;
.source "MicrodataFormImpl.java"

# interfaces
.implements Lcom/comcast/cim/microdata/model/MicrodataForm;


# instance fields
.field private final id:Ljava/lang/String;

.field private final isCollection:Z

.field private final values:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataFormValue;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/comcast/cim/microdata/model/MicrodataFormValue;)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "value"    # Lcom/comcast/cim/microdata/model/MicrodataFormValue;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;->id:Ljava/lang/String;

    .line 17
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;->values:Ljava/util/List;

    .line 18
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;->values:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 20
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;->isCollection:Z

    .line 21
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/util/List;)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataFormValue;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 23
    .local p2, "values":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataFormValue;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;->id:Ljava/lang/String;

    .line 25
    iput-object p2, p0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;->values:Ljava/util/List;

    .line 26
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;->isCollection:Z

    .line 27
    return-void
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Lcom/comcast/cim/microdata/model/MicrodataFormValue;
    .locals 2

    .prologue
    .line 50
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;->values:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 51
    const/4 v0, 0x0

    .line 54
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;->values:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/microdata/model/MicrodataFormValue;

    goto :goto_0
.end method

.method public getValues()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataFormValue;",
            ">;"
        }
    .end annotation

    .prologue
    .line 44
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;->values:Ljava/util/List;

    return-object v0
.end method

.method public isCollection()Z
    .locals 1

    .prologue
    .line 39
    iget-boolean v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;->isCollection:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 60
    new-instance v0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    invoke-direct {v0, p0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;-><init>(Ljava/lang/Object;)V

    .line 61
    .local v0, "builder":Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;
    const-string v1, "id"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;->id:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 62
    const-string v1, "values"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataFormImpl;->values:Ljava/util/List;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 63
    invoke-virtual {v0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
