.class Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContainerCollection;
.super Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;
.source "VirtuosoContainerCollection.java"


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 20
    const/4 v0, 0x3

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;-><init>(I)V

    .line 21
    return-void
.end method

.method constructor <init>(Landroid/database/Cursor;)V
    .locals 0
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 34
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;-><init>(Landroid/database/Cursor;)V

    .line 35
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 0
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;-><init>(Landroid/os/Parcel;)V

    .line 31
    return-void
.end method
