.class Lcom/localytics/android/TestModeListView$TestModeDialog$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$1:Lcom/localytics/android/TestModeListView$TestModeDialog;


# direct methods
.method constructor <init>(Lcom/localytics/android/TestModeListView$TestModeDialog;)V
    .locals 0

    .prologue
    .line 267
    iput-object p1, p0, Lcom/localytics/android/TestModeListView$TestModeDialog$1;->this$1:Lcom/localytics/android/TestModeListView$TestModeDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 271
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$TestModeDialog$1;->this$1:Lcom/localytics/android/TestModeListView$TestModeDialog;

    # getter for: Lcom/localytics/android/TestModeListView$TestModeDialog;->mDialogLayout:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/localytics/android/TestModeListView$TestModeDialog;->access$100(Lcom/localytics/android/TestModeListView$TestModeDialog;)Landroid/widget/RelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/localytics/android/TestModeListView$TestModeDialog$1;->this$1:Lcom/localytics/android/TestModeListView$TestModeDialog;

    # getter for: Lcom/localytics/android/TestModeListView$TestModeDialog;->mAnimOut:Landroid/view/animation/TranslateAnimation;
    invoke-static {v1}, Lcom/localytics/android/TestModeListView$TestModeDialog;->access$000(Lcom/localytics/android/TestModeListView$TestModeDialog;)Landroid/view/animation/TranslateAnimation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 272
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$TestModeDialog$1;->this$1:Lcom/localytics/android/TestModeListView$TestModeDialog;

    iget-object v0, v0, Lcom/localytics/android/TestModeListView$TestModeDialog;->this$0:Lcom/localytics/android/TestModeListView;

    # getter for: Lcom/localytics/android/TestModeListView;->mCallbacks:Ljava/util/Map;
    invoke-static {v0}, Lcom/localytics/android/TestModeListView;->access$200(Lcom/localytics/android/TestModeListView;)Ljava/util/Map;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 274
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$TestModeDialog$1;->this$1:Lcom/localytics/android/TestModeListView$TestModeDialog;

    iget-object v0, v0, Lcom/localytics/android/TestModeListView$TestModeDialog;->this$0:Lcom/localytics/android/TestModeListView;

    # getter for: Lcom/localytics/android/TestModeListView;->mCallbacks:Ljava/util/Map;
    invoke-static {v0}, Lcom/localytics/android/TestModeListView;->access$200(Lcom/localytics/android/TestModeListView;)Ljava/util/Map;

    move-result-object v0

    const/16 v1, 0xa

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingCallable;

    .line 275
    if-eqz v0, :cond_0

    .line 277
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingCallable;->call([Ljava/lang/Object;)Ljava/lang/Object;

    .line 280
    :cond_0
    return-void
.end method
