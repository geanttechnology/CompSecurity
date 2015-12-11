.class Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout$1;
.super Ljava/lang/Object;
.source "SpinnerHiderRelativeLayout.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->init(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 72
    const/4 v0, 0x1

    return v0
.end method
