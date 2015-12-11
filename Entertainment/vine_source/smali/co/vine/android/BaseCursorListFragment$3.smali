.class Lco/vine/android/BaseCursorListFragment$3;
.super Ljava/lang/Object;
.source "BaseCursorListFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/BaseCursorListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/BaseCursorListFragment;


# direct methods
.method constructor <init>(Lco/vine/android/BaseCursorListFragment;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lco/vine/android/BaseCursorListFragment$3;->this$0:Lco/vine/android/BaseCursorListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 90
    iget-object v0, p0, Lco/vine/android/BaseCursorListFragment$3;->this$0:Lco/vine/android/BaseCursorListFragment;

    iget-object v0, v0, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/BaseCursorListFragment$3;->this$0:Lco/vine/android/BaseCursorListFragment;

    iget-object v1, v1, Lco/vine/android/BaseCursorListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->focusableViewAvailable(Landroid/view/View;)V

    .line 91
    return-void
.end method
