.class Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;
.super Ljava/lang/Object;
.source "ShopFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/ShopFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ButtonActionInfo"
.end annotation


# instance fields
.field public fragmentData:Landroid/os/Bundle;

.field public fragmentToLaunch:Ljava/lang/Class;

.field final synthetic this$0:Lcom/poshmark/ui/fragments/ShopFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ShopFragment;)V
    .locals 1

    .prologue
    .line 435
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 437
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;->fragmentData:Landroid/os/Bundle;

    return-void
.end method
