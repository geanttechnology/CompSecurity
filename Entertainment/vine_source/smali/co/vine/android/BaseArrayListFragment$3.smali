.class Lco/vine/android/BaseArrayListFragment$3;
.super Ljava/lang/Object;
.source "BaseArrayListFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/BaseArrayListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/BaseArrayListFragment;


# direct methods
.method constructor <init>(Lco/vine/android/BaseArrayListFragment;)V
    .locals 0

    .prologue
    .line 95
    iput-object p1, p0, Lco/vine/android/BaseArrayListFragment$3;->this$0:Lco/vine/android/BaseArrayListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 97
    iget-object v0, p0, Lco/vine/android/BaseArrayListFragment$3;->this$0:Lco/vine/android/BaseArrayListFragment;

    iget-object v0, v0, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/BaseArrayListFragment$3;->this$0:Lco/vine/android/BaseArrayListFragment;

    iget-object v1, v1, Lco/vine/android/BaseArrayListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->focusableViewAvailable(Landroid/view/View;)V

    .line 98
    return-void
.end method
