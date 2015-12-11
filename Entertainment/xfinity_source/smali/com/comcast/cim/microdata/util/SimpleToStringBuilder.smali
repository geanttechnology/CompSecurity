.class public Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;
.super Ljava/lang/Object;
.source "SimpleToStringBuilder.java"


# instance fields
.field private builder:Ljava/lang/StringBuilder;

.field private firstProperty:Z


# direct methods
.method public constructor <init>(Ljava/lang/Object;)V
    .locals 2
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->firstProperty:Z

    .line 13
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->builder:Ljava/lang/StringBuilder;

    .line 14
    iget-object v0, p0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 15
    iget-object v0, p0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->builder:Ljava/lang/StringBuilder;

    const-string v1, "{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 16
    return-void
.end method

.method private addProperty(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 35
    iget-boolean v0, p0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->firstProperty:Z

    if-nez v0, :cond_0

    .line 36
    iget-object v0, p0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->builder:Ljava/lang/StringBuilder;

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 41
    :goto_0
    iget-object v0, p0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 42
    iget-object v0, p0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->builder:Ljava/lang/StringBuilder;

    const-string v1, ": "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 43
    iget-object v0, p0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 45
    return-object p0

    .line 38
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->firstProperty:Z

    goto :goto_0
.end method


# virtual methods
.method public append(Ljava/lang/String;I)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 23
    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->addProperty(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 19
    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->addProperty(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public append(Ljava/lang/String;Z)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 31
    invoke-static {p2}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->addProperty(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 49
    iget-object v0, p0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->builder:Ljava/lang/StringBuilder;

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 50
    iget-object v0, p0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
