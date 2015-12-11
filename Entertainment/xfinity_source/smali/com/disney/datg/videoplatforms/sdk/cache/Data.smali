.class public Lcom/disney/datg/videoplatforms/sdk/cache/Data;
.super Ljava/lang/Object;
.source "Data.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/io/Serializable;"
    }
.end annotation


# instance fields
.field private accessTime:Ljava/util/Date;

.field private key:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TK;"
        }
    .end annotation
.end field

.field private ttl:I

.field private value:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TV;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/Data;, "Lcom/disney/datg/videoplatforms/sdk/cache/Data<TK;TV;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    const/4 v0, -0x1

    iput v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->ttl:I

    return-void
.end method


# virtual methods
.method public getAccessTime()Ljava/util/Date;
    .locals 1

    .prologue
    .line 40
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/Data;, "Lcom/disney/datg/videoplatforms/sdk/cache/Data<TK;TV;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->accessTime:Ljava/util/Date;

    return-object v0
.end method

.method public getTtl()I
    .locals 1

    .prologue
    .line 28
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/Data;, "Lcom/disney/datg/videoplatforms/sdk/cache/Data<TK;TV;>;"
    iget v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->ttl:I

    return v0
.end method

.method public getValue()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TV;"
        }
    .end annotation

    .prologue
    .line 64
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/Data;, "Lcom/disney/datg/videoplatforms/sdk/cache/Data<TK;TV;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->value:Ljava/lang/Object;

    return-object v0
.end method

.method public setAccessTime(Ljava/util/Date;)V
    .locals 0
    .param p1, "accessTime"    # Ljava/util/Date;

    .prologue
    .line 46
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/Data;, "Lcom/disney/datg/videoplatforms/sdk/cache/Data<TK;TV;>;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->accessTime:Ljava/util/Date;

    .line 47
    return-void
.end method

.method public setKey(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)V"
        }
    .end annotation

    .prologue
    .line 58
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/Data;, "Lcom/disney/datg/videoplatforms/sdk/cache/Data<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->key:Ljava/lang/Object;

    .line 59
    return-void
.end method

.method public setTtl(I)V
    .locals 0
    .param p1, "ttl"    # I

    .prologue
    .line 34
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/Data;, "Lcom/disney/datg/videoplatforms/sdk/cache/Data<TK;TV;>;"
    iput p1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->ttl:I

    .line 35
    return-void
.end method

.method public setValue(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TV;)V"
        }
    .end annotation

    .prologue
    .line 70
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/Data;, "Lcom/disney/datg/videoplatforms/sdk/cache/Data<TK;TV;>;"
    .local p1, "value":Ljava/lang/Object;, "TV;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->value:Ljava/lang/Object;

    .line 71
    return-void
.end method
