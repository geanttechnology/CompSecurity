.class public Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;
.super Landroid/database/DataSetObservable;
.source "GroupCursor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/provider/GroupCursor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "LocalDataSetObservable"
.end annotation


# instance fields
.field private mNotifyOnChange:Z

.field final synthetic this$0:Lco/vine/android/provider/GroupCursor;


# direct methods
.method public constructor <init>(Lco/vine/android/provider/GroupCursor;)V
    .locals 1

    .prologue
    .line 173
    .local p0, "this":Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;, "Lco/vine/android/provider/GroupCursor<TT;>.LocalDataSetObservable;"
    iput-object p1, p0, Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;->this$0:Lco/vine/android/provider/GroupCursor;

    invoke-direct {p0}, Landroid/database/DataSetObservable;-><init>()V

    .line 171
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;->mNotifyOnChange:Z

    .line 174
    return-void
.end method


# virtual methods
.method public notifyChanged()V
    .locals 1

    .prologue
    .line 182
    .local p0, "this":Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;, "Lco/vine/android/provider/GroupCursor<TT;>.LocalDataSetObservable;"
    iget-boolean v0, p0, Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;->mNotifyOnChange:Z

    if-eqz v0, :cond_0

    .line 183
    invoke-super {p0}, Landroid/database/DataSetObservable;->notifyChanged()V

    .line 185
    :cond_0
    return-void
.end method

.method public setNotifyOnChange(Z)V
    .locals 0
    .param p1, "notifyOnChange"    # Z

    .prologue
    .line 177
    .local p0, "this":Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;, "Lco/vine/android/provider/GroupCursor<TT;>.LocalDataSetObservable;"
    iput-boolean p1, p0, Lco/vine/android/provider/GroupCursor$LocalDataSetObservable;->mNotifyOnChange:Z

    .line 178
    return-void
.end method
