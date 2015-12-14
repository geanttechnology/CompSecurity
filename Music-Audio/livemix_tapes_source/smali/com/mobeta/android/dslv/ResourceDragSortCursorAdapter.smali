.class public abstract Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;
.super Lcom/mobeta/android/dslv/DragSortCursorAdapter;
.source "ResourceDragSortCursorAdapter.java"


# instance fields
.field private mDropDownLayout:I

.field private mInflater:Landroid/view/LayoutInflater;

.field private mLayout:I


# direct methods
.method public constructor <init>(Landroid/content/Context;ILandroid/database/Cursor;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "layout"    # I
    .param p3, "c"    # Landroid/database/Cursor;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 56
    invoke-direct {p0, p1, p3}, Lcom/mobeta/android/dslv/DragSortCursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;)V

    .line 57
    iput p2, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mDropDownLayout:I

    iput p2, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mLayout:I

    .line 58
    const-string v0, "layout_inflater"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mInflater:Landroid/view/LayoutInflater;

    .line 59
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;ILandroid/database/Cursor;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "layout"    # I
    .param p3, "c"    # Landroid/database/Cursor;
    .param p4, "flags"    # I

    .prologue
    .line 95
    invoke-direct {p0, p1, p3, p4}, Lcom/mobeta/android/dslv/DragSortCursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 96
    iput p2, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mDropDownLayout:I

    iput p2, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mLayout:I

    .line 97
    const-string v0, "layout_inflater"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mInflater:Landroid/view/LayoutInflater;

    .line 98
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;ILandroid/database/Cursor;Z)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "layout"    # I
    .param p3, "c"    # Landroid/database/Cursor;
    .param p4, "autoRequery"    # Z

    .prologue
    .line 78
    invoke-direct {p0, p1, p3, p4}, Lcom/mobeta/android/dslv/DragSortCursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;Z)V

    .line 79
    iput p2, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mDropDownLayout:I

    iput p2, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mLayout:I

    .line 80
    const-string v0, "layout_inflater"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mInflater:Landroid/view/LayoutInflater;

    .line 81
    return-void
.end method


# virtual methods
.method public newDropDownView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 113
    iget-object v0, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mInflater:Landroid/view/LayoutInflater;

    iget v1, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mDropDownLayout:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p3, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 108
    iget-object v0, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mInflater:Landroid/view/LayoutInflater;

    iget v1, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mLayout:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p3, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public setDropDownViewResource(I)V
    .locals 0
    .param p1, "dropDownLayout"    # I

    .prologue
    .line 131
    iput p1, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mDropDownLayout:I

    .line 132
    return-void
.end method

.method public setViewResource(I)V
    .locals 0
    .param p1, "layout"    # I

    .prologue
    .line 122
    iput p1, p0, Lcom/mobeta/android/dslv/ResourceDragSortCursorAdapter;->mLayout:I

    .line 123
    return-void
.end method
