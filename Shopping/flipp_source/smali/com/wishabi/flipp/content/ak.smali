.class final Lcom/wishabi/flipp/content/ak;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/wishabi/flipp/content/al;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 222
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 2

    .prologue
    .line 222
    check-cast p1, Lcom/wishabi/flipp/content/al;

    check-cast p2, Lcom/wishabi/flipp/content/al;

    iget-boolean v0, p1, Lcom/wishabi/flipp/content/al;->b:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p2, Lcom/wishabi/flipp/content/al;->b:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    iget-boolean v0, p1, Lcom/wishabi/flipp/content/al;->b:Z

    if-nez v0, :cond_1

    iget-boolean v0, p2, Lcom/wishabi/flipp/content/al;->b:Z

    if-eqz v0, :cond_1

    const/4 v0, -0x1

    goto :goto_0

    :cond_1
    iget-object v0, p2, Lcom/wishabi/flipp/content/al;->a:Ljava/lang/String;

    iget-object v1, p1, Lcom/wishabi/flipp/content/al;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v0

    goto :goto_0
.end method
