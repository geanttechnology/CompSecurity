.class public Lco/vine/android/provider/ActivityCursor;
.super Landroid/database/MergeCursor;
.source "ActivityCursor.java"


# static fields
.field public static final EXTRA_NUM_REQUESTS:Ljava/lang/String; = "num_reqs"


# instance fields
.field private mNumFollowRequests:I


# direct methods
.method public constructor <init>([Landroid/database/Cursor;)V
    .locals 0
    .param p1, "cursors"    # [Landroid/database/Cursor;

    .prologue
    .line 16
    invoke-direct {p0, p1}, Landroid/database/MergeCursor;-><init>([Landroid/database/Cursor;)V

    .line 17
    return-void
.end method

.method public constructor <init>([Landroid/database/Cursor;I)V
    .locals 0
    .param p1, "cursors"    # [Landroid/database/Cursor;
    .param p2, "numFollowRequests"    # I

    .prologue
    .line 20
    invoke-direct {p0, p1}, Landroid/database/MergeCursor;-><init>([Landroid/database/Cursor;)V

    .line 21
    iput p2, p0, Lco/vine/android/provider/ActivityCursor;->mNumFollowRequests:I

    .line 22
    return-void
.end method


# virtual methods
.method public getExtras()Landroid/os/Bundle;
    .locals 3

    .prologue
    .line 26
    new-instance v0, Landroid/os/Bundle;

    invoke-super {p0}, Landroid/database/MergeCursor;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    .line 27
    .local v0, "extras":Landroid/os/Bundle;
    const-string v1, "num_reqs"

    iget v2, p0, Lco/vine/android/provider/ActivityCursor;->mNumFollowRequests:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 28
    return-object v0
.end method
