.class Lco/vine/android/InboxFragment$4;
.super Lco/vine/android/OnContactEntryClickedListener;
.source "InboxFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/InboxFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/InboxFragment;


# direct methods
.method constructor <init>(Lco/vine/android/InboxFragment;)V
    .locals 0

    .prologue
    .line 777
    iput-object p1, p0, Lco/vine/android/InboxFragment$4;->this$0:Lco/vine/android/InboxFragment;

    invoke-direct {p0}, Lco/vine/android/OnContactEntryClickedListener;-><init>()V

    return-void
.end method


# virtual methods
.method protected onContactEntryClicked(Lco/vine/android/ContactEntry;Lco/vine/android/api/VineRecipient;ILjava/lang/String;)V
    .locals 4
    .param p1, "entry"    # Lco/vine/android/ContactEntry;
    .param p2, "recipient"    # Lco/vine/android/api/VineRecipient;
    .param p3, "typeFlag"    # I
    .param p4, "value"    # Ljava/lang/String;

    .prologue
    .line 781
    iget-object v0, p0, Lco/vine/android/InboxFragment$4;->this$0:Lco/vine/android/InboxFragment;

    iget-wide v0, v0, Lco/vine/android/InboxFragment;->mWaitingToStartId:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 782
    iget-object v0, p0, Lco/vine/android/InboxFragment$4;->this$0:Lco/vine/android/InboxFragment;

    iget-wide v1, p2, Lco/vine/android/api/VineRecipient;->contactId:J

    iput-wide v1, v0, Lco/vine/android/InboxFragment;->mWaitingToStartId:J

    .line 783
    iget-object v0, p0, Lco/vine/android/InboxFragment$4;->this$0:Lco/vine/android/InboxFragment;

    iget-object v0, v0, Lco/vine/android/InboxFragment;->mAppController:Lco/vine/android/client/AppController;

    const/4 v1, 0x1

    invoke-virtual {v0, p2, v1}, Lco/vine/android/client/AppController;->fetchConversationRowIdFromSingleRecipient(Lco/vine/android/api/VineRecipient;I)V

    .line 785
    :cond_0
    return-void
.end method
