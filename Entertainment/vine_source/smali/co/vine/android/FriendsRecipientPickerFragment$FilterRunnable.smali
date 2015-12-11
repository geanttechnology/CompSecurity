.class Lco/vine/android/FriendsRecipientPickerFragment$FilterRunnable;
.super Ljava/lang/Object;
.source "FriendsRecipientPickerFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/FriendsRecipientPickerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FilterRunnable"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/FriendsRecipientPickerFragment;


# direct methods
.method public constructor <init>(Lco/vine/android/FriendsRecipientPickerFragment;Ljava/lang/String;)V
    .locals 0
    .param p2, "query"    # Ljava/lang/String;

    .prologue
    .line 281
    iput-object p1, p0, Lco/vine/android/FriendsRecipientPickerFragment$FilterRunnable;->this$0:Lco/vine/android/FriendsRecipientPickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 282
    iput-object p2, p1, Lco/vine/android/FriendsRecipientPickerFragment;->mQueryString:Ljava/lang/String;

    .line 283
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 287
    iget-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment$FilterRunnable;->this$0:Lco/vine/android/FriendsRecipientPickerFragment;

    iget-object v1, p0, Lco/vine/android/FriendsRecipientPickerFragment$FilterRunnable;->this$0:Lco/vine/android/FriendsRecipientPickerFragment;

    iget-object v1, v1, Lco/vine/android/FriendsRecipientPickerFragment;->mQueryString:Ljava/lang/String;

    # setter for: Lco/vine/android/FriendsRecipientPickerFragment;->mLastFiredQuery:Ljava/lang/String;
    invoke-static {v0, v1}, Lco/vine/android/FriendsRecipientPickerFragment;->access$002(Lco/vine/android/FriendsRecipientPickerFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 288
    iget-object v0, p0, Lco/vine/android/FriendsRecipientPickerFragment$FilterRunnable;->this$0:Lco/vine/android/FriendsRecipientPickerFragment;

    iget-object v0, v0, Lco/vine/android/FriendsRecipientPickerFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/FriendsRecipientPickerFragment$FilterRunnable;->this$0:Lco/vine/android/FriendsRecipientPickerFragment;

    iget-object v1, v1, Lco/vine/android/FriendsRecipientPickerFragment;->mQueryString:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lco/vine/android/client/AppController;->fetchFriendsTypeAhead(Ljava/lang/String;)Ljava/lang/String;

    .line 289
    return-void
.end method
