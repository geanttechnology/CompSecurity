.class public Lcom/comcast/cim/cmasl/http/response/ResponseId;
.super Ljava/lang/Object;
.source "ResponseId.java"


# instance fields
.field private final lastModified:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "lastModified"    # Ljava/lang/String;

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    iput-object p1, p0, Lcom/comcast/cim/cmasl/http/response/ResponseId;->lastModified:Ljava/lang/String;

    .line 11
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 20
    if-ne p0, p1, :cond_0

    .line 21
    const/4 v1, 0x1

    .line 27
    :goto_0
    return v1

    .line 23
    :cond_0
    if-eqz p1, :cond_1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    if-eq v1, v2, :cond_2

    .line 24
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    :cond_2
    move-object v0, p1

    .line 26
    check-cast v0, Lcom/comcast/cim/cmasl/http/response/ResponseId;

    .line 27
    .local v0, "id":Lcom/comcast/cim/cmasl/http/response/ResponseId;
    iget-object v1, p0, Lcom/comcast/cim/cmasl/http/response/ResponseId;->lastModified:Ljava/lang/String;

    iget-object v2, v0, Lcom/comcast/cim/cmasl/http/response/ResponseId;->lastModified:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/response/ResponseId;->lastModified:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 15
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "lastModified:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/http/response/ResponseId;->lastModified:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
