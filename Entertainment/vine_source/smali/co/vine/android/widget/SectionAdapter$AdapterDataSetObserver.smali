.class Lco/vine/android/widget/SectionAdapter$AdapterDataSetObserver;
.super Landroid/database/DataSetObserver;
.source "SectionAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/widget/SectionAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "AdapterDataSetObserver"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/widget/SectionAdapter;


# direct methods
.method constructor <init>(Lco/vine/android/widget/SectionAdapter;)V
    .locals 0

    .prologue
    .line 380
    iput-object p1, p0, Lco/vine/android/widget/SectionAdapter$AdapterDataSetObserver;->this$0:Lco/vine/android/widget/SectionAdapter;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 1

    .prologue
    .line 388
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter$AdapterDataSetObserver;->this$0:Lco/vine/android/widget/SectionAdapter;

    iget-boolean v0, v0, Lco/vine/android/widget/SectionAdapter;->mNotifyOnChange:Z

    if-eqz v0, :cond_0

    .line 389
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter$AdapterDataSetObserver;->this$0:Lco/vine/android/widget/SectionAdapter;

    invoke-virtual {v0}, Lco/vine/android/widget/SectionAdapter;->notifyDataSetChanged()V

    .line 391
    :cond_0
    return-void
.end method

.method public onInvalidated()V
    .locals 1

    .prologue
    .line 383
    iget-object v0, p0, Lco/vine/android/widget/SectionAdapter$AdapterDataSetObserver;->this$0:Lco/vine/android/widget/SectionAdapter;

    invoke-virtual {v0}, Lco/vine/android/widget/SectionAdapter;->notifyDataSetInvalidated()V

    .line 384
    return-void
.end method
