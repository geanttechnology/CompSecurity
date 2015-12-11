.class Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$2;
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

.field final synthetic val$slideClosedRequestListener:Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$2;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$2;->val$slideClosedRequestListener:Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 74
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayerSideMenuBuilder$2;->val$slideClosedRequestListener:Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;->slideClosed(Lcom/comcast/cim/android/sideribbon/SlideClosedListener;)V

    .line 75
    return-void
.end method
