.class public interface abstract Lcom/penthera/virtuososdk/client/IVirtuosoFile;
.super Ljava/lang/Object;
.source "IVirtuosoFile.java"

# interfaces
.implements Lcom/penthera/virtuososdk/client/IVirtuosoAsset;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoFile;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 78
    sget-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/InterfaceFactory;->FILE_CREATOR:Landroid/os/Parcelable$Creator;

    sput-object v0, Lcom/penthera/virtuososdk/client/IVirtuosoFile;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 33
    return-void
.end method


# virtual methods
.method public abstract errorCount()J
.end method

.method public abstract fileMD5()Ljava/lang/String;
.end method

.method public abstract filePath()Ljava/lang/String;
.end method

.method public abstract mimeType()Ljava/lang/String;
.end method

.method public abstract setExpectedSize(D)V
.end method
