.class final Lcom/wishabi/flipp/app/cl;
.super Lcom/wishabi/flipp/b/ag;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/HelpActivity;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/HelpActivity;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 458
    iput-object p1, p0, Lcom/wishabi/flipp/app/cl;->a:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-direct {p0, p2}, Lcom/wishabi/flipp/b/ag;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method protected final a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 461
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x5

    if-lt v0, v1, :cond_0

    .line 462
    iget-object v0, p0, Lcom/wishabi/flipp/app/cl;->a:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-static {v0, p1}, Lcom/wishabi/flipp/app/HelpActivity;->a(Lcom/wishabi/flipp/app/HelpActivity;Ljava/lang/String;)Ljava/lang/String;

    .line 463
    :cond_0
    return-void
.end method
