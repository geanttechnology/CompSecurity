.class final Lcom/wishabi/flipp/app/bb;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/app/bn;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FlyerActivity;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FlyerActivity;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/wishabi/flipp/app/bb;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/view/View;Lcom/wishabi/flipp/content/Flyer$Model;)V
    .locals 2

    .prologue
    .line 61
    iget-object v0, p0, Lcom/wishabi/flipp/app/bb;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-static {v0, p2}, Lcom/wishabi/flipp/app/FlyerActivity;->a(Lcom/wishabi/flipp/app/FlyerActivity;Lcom/wishabi/flipp/content/Flyer$Model;)Lcom/wishabi/flipp/content/Flyer$Model;

    .line 63
    iget-object v0, p0, Lcom/wishabi/flipp/app/bb;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/FlyerActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 64
    if-eqz v0, :cond_0

    .line 65
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 66
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 67
    invoke-virtual {v0, p1}, Landroid/app/ActionBar;->setCustomView(Landroid/view/View;)V

    .line 70
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/bb;->a:Lcom/wishabi/flipp/app/FlyerActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlyerActivity;->a(Lcom/wishabi/flipp/app/FlyerActivity;)V

    .line 71
    return-void
.end method
