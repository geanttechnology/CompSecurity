.class Lcom/livemixtapes/ProfileFragment$1;
.super Ljava/lang/Object;
.source "ProfileFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/ProfileFragment;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/ProfileFragment;


# direct methods
.method constructor <init>(Lcom/livemixtapes/ProfileFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/ProfileFragment$1;->this$0:Lcom/livemixtapes/ProfileFragment;

    .line 336
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 339
    invoke-static {}, Lcom/livemixtapes/User;->logout()V

    .line 342
    :try_start_0
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->stop()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 347
    :goto_0
    sget-object v0, Lcom/livemixtapes/MainActivity;->activity:Landroid/app/Activity;

    new-instance v1, Landroid/content/Intent;

    sget-object v2, Lcom/livemixtapes/MainActivity;->activity:Landroid/app/Activity;

    .line 348
    const-class v3, Lcom/livemixtapes/Login;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 347
    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 349
    sget-object v0, Lcom/livemixtapes/MainActivity;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 350
    return-void

    .line 344
    :catch_0
    move-exception v0

    goto :goto_0
.end method
