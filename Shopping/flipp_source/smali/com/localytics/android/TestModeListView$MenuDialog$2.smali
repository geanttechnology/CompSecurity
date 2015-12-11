.class Lcom/localytics/android/TestModeListView$MenuDialog$2;
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
    .line 553
    iput-object p1, p0, Lcom/localytics/android/TestModeListView$MenuDialog$2;->this$1:Lcom/localytics/android/TestModeListView$MenuDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 1
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
    .line 557
    iget-object v0, p0, Lcom/localytics/android/TestModeListView$MenuDialog$2;->this$1:Lcom/localytics/android/TestModeListView$MenuDialog;

    invoke-virtual {v0}, Lcom/localytics/android/TestModeListView$MenuDialog;->dismiss()V

    .line 558
    return-void
.end method
