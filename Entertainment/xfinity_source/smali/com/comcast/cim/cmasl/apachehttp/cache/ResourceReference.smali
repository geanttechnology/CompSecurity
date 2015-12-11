.class public Lcom/comcast/cim/cmasl/apachehttp/cache/ResourceReference;
.super Ljava/lang/ref/PhantomReference;
.source "ResourceReference.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/ref/PhantomReference",
        "<",
        "Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;",
        ">;"
    }
.end annotation


# instance fields
.field private final backingFile:Ljava/io/File;


# direct methods
.method public constructor <init>(Ljava/io/File;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;Ljava/lang/ref/ReferenceQueue;)V
    .locals 0
    .param p1, "backingFile"    # Ljava/io/File;
    .param p2, "resource"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;",
            "Ljava/lang/ref/ReferenceQueue",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 14
    .local p3, "queue":Ljava/lang/ref/ReferenceQueue;, "Ljava/lang/ref/ReferenceQueue<Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;>;"
    invoke-direct {p0, p2, p3}, Ljava/lang/ref/PhantomReference;-><init>(Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V

    .line 15
    iput-object p1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ResourceReference;->backingFile:Ljava/io/File;

    .line 16
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 29
    if-ne p0, p1, :cond_0

    .line 30
    const/4 v1, 0x1

    .line 36
    :goto_0
    return v1

    .line 32
    :cond_0
    if-eqz p1, :cond_1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    if-eq v1, v2, :cond_2

    .line 33
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    :cond_2
    move-object v0, p1

    .line 35
    check-cast v0, Lcom/comcast/cim/cmasl/apachehttp/cache/ResourceReference;

    .line 36
    .local v0, "that":Lcom/comcast/cim/cmasl/apachehttp/cache/ResourceReference;
    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ResourceReference;->backingFile:Ljava/io/File;

    iget-object v2, v0, Lcom/comcast/cim/cmasl/apachehttp/cache/ResourceReference;->backingFile:Ljava/io/File;

    invoke-virtual {v1, v2}, Ljava/io/File;->equals(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0
.end method

.method public getBackingFile()Ljava/io/File;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ResourceReference;->backingFile:Ljava/io/File;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ResourceReference;->backingFile:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->hashCode()I

    move-result v0

    return v0
.end method
