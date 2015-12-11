.class Lcom/poshmark/ui/PMContainerActivity$1;
.super Ljava/lang/Object;
.source "PMContainerActivity.java"

# interfaces
.implements Landroid/support/v4/app/FragmentManager$OnBackStackChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/PMContainerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/PMContainerActivity;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/PMContainerActivity;)V
    .locals 0

    .prologue
    .line 429
    iput-object p1, p0, Lcom/poshmark/ui/PMContainerActivity$1;->this$0:Lcom/poshmark/ui/PMContainerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onBackStackChanged()V
    .locals 2

    .prologue
    .line 432
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/poshmark/ui/PMContainerActivity$1$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/PMContainerActivity$1$1;-><init>(Lcom/poshmark/ui/PMContainerActivity$1;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 441
    return-void
.end method
