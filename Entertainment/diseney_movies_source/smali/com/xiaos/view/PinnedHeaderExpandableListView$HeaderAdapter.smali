.class public interface abstract Lcom/xiaos/view/PinnedHeaderExpandableListView$HeaderAdapter;
.super Ljava/lang/Object;
.source "PinnedHeaderExpandableListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xiaos/view/PinnedHeaderExpandableListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "HeaderAdapter"
.end annotation


# static fields
.field public static final PINNED_HEADER_GONE:I = 0x0

.field public static final PINNED_HEADER_PUSHED_UP:I = 0x2

.field public static final PINNED_HEADER_VISIBLE:I = 0x1


# virtual methods
.method public abstract configureHeader(Landroid/view/View;III)V
.end method

.method public abstract getGroupClickStatus(I)I
.end method

.method public abstract getHeaderState(II)I
.end method

.method public abstract setGroupClickStatus(II)V
.end method
