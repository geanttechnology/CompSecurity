.class Lco/vine/android/ConversationFragment$4;
.super Ljava/lang/Object;
.source "ConversationFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/ConversationFragment;->scrollToBottom(ZZ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ConversationFragment;

.field final synthetic val$count:I

.field final synthetic val$listView:Landroid/widget/ListView;

.field final synthetic val$smooth:Z


# direct methods
.method constructor <init>(Lco/vine/android/ConversationFragment;ZLandroid/widget/ListView;I)V
    .locals 0

    .prologue
    .line 623
    iput-object p1, p0, Lco/vine/android/ConversationFragment$4;->this$0:Lco/vine/android/ConversationFragment;

    iput-boolean p2, p0, Lco/vine/android/ConversationFragment$4;->val$smooth:Z

    iput-object p3, p0, Lco/vine/android/ConversationFragment$4;->val$listView:Landroid/widget/ListView;

    iput p4, p0, Lco/vine/android/ConversationFragment$4;->val$count:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 626
    iget-boolean v0, p0, Lco/vine/android/ConversationFragment$4;->val$smooth:Z

    if-eqz v0, :cond_0

    .line 627
    iget-object v0, p0, Lco/vine/android/ConversationFragment$4;->val$listView:Landroid/widget/ListView;

    iget v1, p0, Lco/vine/android/ConversationFragment$4;->val$count:I

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->smoothScrollToPosition(I)V

    .line 631
    :goto_0
    return-void

    .line 629
    :cond_0
    iget-object v0, p0, Lco/vine/android/ConversationFragment$4;->val$listView:Landroid/widget/ListView;

    iget v1, p0, Lco/vine/android/ConversationFragment$4;->val$count:I

    add-int/lit8 v1, v1, -0x1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/widget/ListView;->setSelectionFromTop(II)V

    goto :goto_0
.end method
