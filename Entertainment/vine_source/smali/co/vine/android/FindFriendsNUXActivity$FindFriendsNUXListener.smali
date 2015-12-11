.class Lco/vine/android/FindFriendsNUXActivity$FindFriendsNUXListener;
.super Lco/vine/android/client/AppSessionListener;
.source "FindFriendsNUXActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/FindFriendsNUXActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FindFriendsNUXListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/FindFriendsNUXActivity;


# direct methods
.method private constructor <init>(Lco/vine/android/FindFriendsNUXActivity;)V
    .locals 0

    .prologue
    .line 313
    iput-object p1, p0, Lco/vine/android/FindFriendsNUXActivity$FindFriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXActivity;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/FindFriendsNUXActivity;Lco/vine/android/FindFriendsNUXActivity$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/FindFriendsNUXActivity;
    .param p2, "x1"    # Lco/vine/android/FindFriendsNUXActivity$1;

    .prologue
    .line 313
    invoke-direct {p0, p1}, Lco/vine/android/FindFriendsNUXActivity$FindFriendsNUXListener;-><init>(Lco/vine/android/FindFriendsNUXActivity;)V

    return-void
.end method


# virtual methods
.method public onBulkFollowComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 316
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity$FindFriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXActivity;

    invoke-virtual {v0}, Lco/vine/android/FindFriendsNUXActivity;->dismissDialog()V

    .line 317
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity$FindFriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXActivity;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lco/vine/android/StartActivity;->toStart(Landroid/content/Context;Z)V

    .line 318
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity$FindFriendsNUXListener;->this$0:Lco/vine/android/FindFriendsNUXActivity;

    invoke-virtual {v0}, Lco/vine/android/FindFriendsNUXActivity;->finish()V

    .line 319
    return-void
.end method
