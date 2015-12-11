.class final Lcom/wishabi/flipp/content/bh;
.super Landroid/database/ContentObserver;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/content/UserContentProvider;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/content/UserContentProvider;Landroid/os/Handler;)V
    .locals 0

    .prologue
    .line 498
    iput-object p1, p0, Lcom/wishabi/flipp/content/bh;->a:Lcom/wishabi/flipp/content/UserContentProvider;

    invoke-direct {p0, p2}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    return-void
.end method


# virtual methods
.method public final onChange(Z)V
    .locals 3

    .prologue
    .line 501
    iget-object v0, p0, Lcom/wishabi/flipp/content/bh;->a:Lcom/wishabi/flipp/content/UserContentProvider;

    invoke-virtual {v0}, Lcom/wishabi/flipp/content/UserContentProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->r:Landroid/net/Uri;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 503
    return-void
.end method
