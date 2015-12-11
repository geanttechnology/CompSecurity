.class Lcom/localytics/android/TestModeListView$MenuDialog$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# instance fields
.field final synthetic this$1:Lcom/localytics/android/TestModeListView$MenuDialog;


# direct methods
.method constructor <init>(Lcom/localytics/android/TestModeListView$MenuDialog;)V
    .locals 0

    .prologue
    .line 479
    iput-object p1, p0, Lcom/localytics/android/TestModeListView$MenuDialog$1;->this$1:Lcom/localytics/android/TestModeListView$MenuDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 484
    if-nez p3, :cond_1

    .line 486
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/localytics/android/Constants;->setTestModeEnabled(Z)V

    .line 487
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog$1;->this$1:Lcom/localytics/android/TestModeListView$MenuDialog;

    iget-object v0, v0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    invoke-virtual {v0}, Lcom/localytics/android/TestModeListView;->dismiss()V

    .line 523
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog$1;->this$1:Lcom/localytics/android/TestModeListView$MenuDialog;

    invoke-virtual {v0}, Lcom/localytics/android/TestModeListView$MenuDialog;->dismiss()V

    .line 524
    return-void

    .line 489
    :cond_1
    const/4 v0, 0x1

    if-ne p3, v0, :cond_2

    .line 491
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog$1;->this$1:Lcom/localytics/android/TestModeListView$MenuDialog;

    iget-object v0, v0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    # getter for: Lcom/localytics/android/TestModeListView;->mCallbacks:Ljava/util/Map;
    invoke-static {v0}, Lcom/localytics/android/TestModeListView;->access$200(Lcom/localytics/android/TestModeListView;)Ljava/util/Map;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 493
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog$1;->this$1:Lcom/localytics/android/TestModeListView$MenuDialog;

    iget-object v0, v0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    # getter for: Lcom/localytics/android/TestModeListView;->mCallbacks:Ljava/util/Map;
    invoke-static {v0}, Lcom/localytics/android/TestModeListView;->access$200(Lcom/localytics/android/TestModeListView;)Ljava/util/Map;

    move-result-object v0

    const/16 v1, 0xc

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingCallable;

    .line 494
    if-eqz v0, :cond_0

    .line 496
    invoke-virtual {v0, v2}, Lcom/localytics/android/MarketingCallable;->call([Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 500
    :cond_2
    const/4 v0, 0x2

    if-ne p3, v0, :cond_3

    .line 502
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog$1;->this$1:Lcom/localytics/android/TestModeListView$MenuDialog;

    iget-object v0, v0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    # getter for: Lcom/localytics/android/TestModeListView;->mCallbacks:Ljava/util/Map;
    invoke-static {v0}, Lcom/localytics/android/TestModeListView;->access$200(Lcom/localytics/android/TestModeListView;)Ljava/util/Map;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 504
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog$1;->this$1:Lcom/localytics/android/TestModeListView$MenuDialog;

    iget-object v0, v0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    # getter for: Lcom/localytics/android/TestModeListView;->mCallbacks:Ljava/util/Map;
    invoke-static {v0}, Lcom/localytics/android/TestModeListView;->access$200(Lcom/localytics/android/TestModeListView;)Ljava/util/Map;

    move-result-object v0

    const/16 v1, 0xd

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingCallable;

    .line 505
    if-eqz v0, :cond_0

    .line 507
    invoke-virtual {v0, v2}, Lcom/localytics/android/MarketingCallable;->call([Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 511
    :cond_3
    const/4 v0, 0x3

    if-ne p3, v0, :cond_0

    .line 513
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog$1;->this$1:Lcom/localytics/android/TestModeListView$MenuDialog;

    iget-object v0, v0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    # getter for: Lcom/localytics/android/TestModeListView;->mCallbacks:Ljava/util/Map;
    invoke-static {v0}, Lcom/localytics/android/TestModeListView;->access$200(Lcom/localytics/android/TestModeListView;)Ljava/util/Map;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 515
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog$1;->this$1:Lcom/localytics/android/TestModeListView$MenuDialog;

    iget-object v0, v0, Lcom/localytics/android/TestModeListView$MenuDialog;->this$0:Lcom/localytics/android/TestModeListView;

    # getter for: Lcom/localytics/android/TestModeListView;->mCallbacks:Ljava/util/Map;
    invoke-static {v0}, Lcom/localytics/android/TestModeListView;->access$200(Lcom/localytics/android/TestModeListView;)Ljava/util/Map;

    move-result-object v0

    const/16 v1, 0xe

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingCallable;

    .line 516
    if-eqz v0, :cond_0

    .line 518
    invoke-virtual {v0, v2}, Lcom/localytics/android/MarketingCallable;->call([Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method
