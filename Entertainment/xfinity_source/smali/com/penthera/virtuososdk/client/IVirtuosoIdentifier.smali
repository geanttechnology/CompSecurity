.class public interface abstract Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
.super Ljava/lang/Object;
.source "IVirtuosoIdentifier.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    sget-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/InterfaceFactory;->FD_CREATOR:Landroid/os/Parcelable$Creator;

    sput-object v0, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 13
    return-void
.end method


# virtual methods
.method public abstract completionTime()J
.end method

.method public abstract downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
.end method

.method public abstract id()I
.end method

.method public abstract parentUuid()Ljava/lang/String;
.end method

.method public abstract type()I
.end method

.method public abstract uuid()Ljava/lang/String;
.end method
