.class Lco/vine/android/ConversationFragment$6;
.super Ljava/lang/Object;
.source "ConversationFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ConversationFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ConversationFragment;


# direct methods
.method constructor <init>(Lco/vine/android/ConversationFragment;)V
    .locals 0

    .prologue
    .line 740
    iput-object p1, p0, Lco/vine/android/ConversationFragment$6;->this$0:Lco/vine/android/ConversationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 744
    iget-object v0, p0, Lco/vine/android/ConversationFragment$6;->this$0:Lco/vine/android/ConversationFragment;

    invoke-virtual {v0}, Lco/vine/android/ConversationFragment;->launchFullRecord()V

    .line 745
    return-void
.end method
