.class final Lcom/amazon/ansel/fetch/LoaderContext$1;
.super Ljava/lang/Object;
.source "LoaderContext.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/ansel/fetch/LoaderContext;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 7
    .param p1, "a"    # Ljava/lang/Object;
    .param p2, "b"    # Ljava/lang/Object;

    .prologue
    const-wide/16 v4, 0x0

    .line 69
    instance-of v6, p1, Lcom/amazon/ansel/fetch/Prioritized;

    if-eqz v6, :cond_0

    check-cast p1, Lcom/amazon/ansel/fetch/Prioritized;

    .end local p1    # "a":Ljava/lang/Object;
    invoke-interface {p1}, Lcom/amazon/ansel/fetch/Prioritized;->getPriority()J

    move-result-wide v0

    .line 70
    .local v0, "x":J
    :goto_0
    instance-of v6, p2, Lcom/amazon/ansel/fetch/Prioritized;

    if-eqz v6, :cond_1

    check-cast p2, Lcom/amazon/ansel/fetch/Prioritized;

    .end local p2    # "b":Ljava/lang/Object;
    invoke-interface {p2}, Lcom/amazon/ansel/fetch/Prioritized;->getPriority()J

    move-result-wide v2

    .line 71
    .local v2, "y":J
    :goto_1
    cmp-long v4, v0, v2

    if-gez v4, :cond_2

    const/4 v4, 0x1

    :goto_2
    return v4

    .end local v0    # "x":J
    .end local v2    # "y":J
    .restart local p1    # "a":Ljava/lang/Object;
    .restart local p2    # "b":Ljava/lang/Object;
    :cond_0
    move-wide v0, v4

    .line 69
    goto :goto_0

    .end local p1    # "a":Ljava/lang/Object;
    .restart local v0    # "x":J
    :cond_1
    move-wide v2, v4

    .line 70
    goto :goto_1

    .line 71
    .end local p2    # "b":Ljava/lang/Object;
    .restart local v2    # "y":J
    :cond_2
    cmp-long v4, v0, v2

    if-nez v4, :cond_3

    const/4 v4, 0x0

    goto :goto_2

    :cond_3
    const/4 v4, -0x1

    goto :goto_2
.end method
