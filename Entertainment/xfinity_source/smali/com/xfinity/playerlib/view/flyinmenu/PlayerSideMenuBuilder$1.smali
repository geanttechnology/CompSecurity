.class Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$1;
.super Ljava/lang/Object;
.source "PlayerSideMenuBuilder.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;->inflateMenuGroup(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuAdapter;Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;

.field final synthetic val$activity:Landroid/app/Activity;

.field final synthetic val$item:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

.field final synthetic val$slideClosedRequestListener:Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;Landroid/app/Activity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$1;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$1;->val$slideClosedRequestListener:Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$1;->val$item:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    iput-object p4, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$1;->val$activity:Landroid/app/Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$1;->val$slideClosedRequestListener:Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;

    new-instance v1, Lcom/xfinity/playerlib/view/flyinmenu/PlayerActivityStarter;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$1;->val$item:Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;->getActivity()Ljava/lang/Class;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$1;->val$activity:Landroid/app/Activity;

    invoke-direct {v1, v2, v3}, Lcom/xfinity/playerlib/view/flyinmenu/PlayerActivityStarter;-><init>(Ljava/lang/Class;Landroid/app/Activity;)V

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;->slideClosed(Lcom/comcast/cim/android/sideribbon/SlideClosedListener;)V

    .line 63
    return-void
.end method
