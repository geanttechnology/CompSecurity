.class Lorg/simpleframework/xml/core/Hierarchy;
.super Ljava/util/LinkedList;
.source "Hierarchy.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/LinkedList",
        "<",
        "Ljava/lang/Class;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/Class;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/Class;

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/util/LinkedList;-><init>()V

    .line 44
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/Hierarchy;->scan(Ljava/lang/Class;)V

    .line 45
    return-void
.end method

.method private scan(Ljava/lang/Class;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;

    .prologue
    .line 55
    :goto_0
    if-eqz p1, :cond_0

    .line 56
    invoke-virtual {p0, p1}, Lorg/simpleframework/xml/core/Hierarchy;->addFirst(Ljava/lang/Object;)V

    .line 57
    invoke-virtual {p1}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object p1

    goto :goto_0

    .line 59
    :cond_0
    const-class v0, Ljava/lang/Object;

    invoke-virtual {p0, v0}, Lorg/simpleframework/xml/core/Hierarchy;->remove(Ljava/lang/Object;)Z

    .line 60
    return-void
.end method
