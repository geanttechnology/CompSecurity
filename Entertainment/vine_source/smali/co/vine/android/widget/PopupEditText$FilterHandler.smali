.class Lco/vine/android/widget/PopupEditText$FilterHandler;
.super Landroid/os/Handler;
.source "PopupEditText.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/widget/PopupEditText;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "FilterHandler"
.end annotation


# instance fields
.field private mFilterable:Landroid/widget/Filterable;

.field private final mListenerRef:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/widget/Filter$FilterListener;",
            ">;"
        }
    .end annotation
.end field

.field private mOnFilterListener:Lco/vine/android/widget/PopupEditText$PopupEditTextListener;


# direct methods
.method public constructor <init>(Landroid/os/Looper;Landroid/widget/Filter$FilterListener;)V
    .locals 1
    .param p1, "looper"    # Landroid/os/Looper;
    .param p2, "listener"    # Landroid/widget/Filter$FilterListener;

    .prologue
    .line 559
    invoke-direct {p0, p1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 560
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lco/vine/android/widget/PopupEditText$FilterHandler;->mListenerRef:Ljava/lang/ref/WeakReference;

    .line 561
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 565
    iget-object v2, p0, Lco/vine/android/widget/PopupEditText$FilterHandler;->mListenerRef:Ljava/lang/ref/WeakReference;

    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Filter$FilterListener;

    .line 566
    .local v0, "listener":Landroid/widget/Filter$FilterListener;
    iget-object v2, p0, Lco/vine/android/widget/PopupEditText$FilterHandler;->mFilterable:Landroid/widget/Filterable;

    if-eqz v2, :cond_0

    if-eqz v0, :cond_0

    .line 567
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Ljava/lang/CharSequence;

    .line 568
    .local v1, "token":Ljava/lang/CharSequence;
    iget-object v2, p0, Lco/vine/android/widget/PopupEditText$FilterHandler;->mFilterable:Landroid/widget/Filterable;

    invoke-interface {v2}, Landroid/widget/Filterable;->getFilter()Landroid/widget/Filter;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Landroid/widget/Filter;->filter(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterListener;)V

    .line 569
    iget v2, p1, Landroid/os/Message;->arg1:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    iget-object v2, p0, Lco/vine/android/widget/PopupEditText$FilterHandler;->mOnFilterListener:Lco/vine/android/widget/PopupEditText$PopupEditTextListener;

    if-eqz v2, :cond_0

    .line 570
    iget-object v2, p0, Lco/vine/android/widget/PopupEditText$FilterHandler;->mOnFilterListener:Lco/vine/android/widget/PopupEditText$PopupEditTextListener;

    invoke-interface {v2, v1}, Lco/vine/android/widget/PopupEditText$PopupEditTextListener;->onFiltering(Ljava/lang/CharSequence;)V

    .line 573
    .end local v1    # "token":Ljava/lang/CharSequence;
    :cond_0
    return-void
.end method

.method public setFilterable(Landroid/widget/Filterable;)V
    .locals 0
    .param p1, "filterable"    # Landroid/widget/Filterable;

    .prologue
    .line 576
    iput-object p1, p0, Lco/vine/android/widget/PopupEditText$FilterHandler;->mFilterable:Landroid/widget/Filterable;

    .line 577
    return-void
.end method

.method public setOnFilterListener(Lco/vine/android/widget/PopupEditText$PopupEditTextListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/widget/PopupEditText$PopupEditTextListener;

    .prologue
    .line 580
    iput-object p1, p0, Lco/vine/android/widget/PopupEditText$FilterHandler;->mOnFilterListener:Lco/vine/android/widget/PopupEditText$PopupEditTextListener;

    .line 581
    return-void
.end method
