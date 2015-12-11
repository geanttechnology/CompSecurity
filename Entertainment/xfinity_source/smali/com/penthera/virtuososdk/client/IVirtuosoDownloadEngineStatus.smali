.class public interface abstract Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
.super Ljava/lang/Object;
.source "IVirtuosoDownloadEngineStatus.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 34
    sget-object v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->CREATOR:Landroid/os/Parcelable$Creator;

    sput-object v0, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 25
    return-void
.end method


# virtual methods
.method public abstract status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
.end method
