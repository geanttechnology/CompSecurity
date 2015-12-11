.class public abstract Landroid/content/pm/IPackageDeleteObserver$Stub;
.super Landroid/os/Binder;
.source "IPackageDeleteObserver.java"

# interfaces
.implements Landroid/content/pm/IPackageDeleteObserver;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/pm/IPackageDeleteObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 22
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 23
    const-string/jumbo v0, "android.content.pm.IPackageDeleteObserver"

    invoke-virtual {p0, p0, v0}, Landroid/content/pm/IPackageDeleteObserver$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 24
    return-void
.end method

.method private isPreIceCreamSandwich()Z
    .locals 2

    .prologue
    .line 27
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-ge v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .locals 0

    .prologue
    .line 51
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .locals 5
    .param p1, "code"    # I
    .param p2, "data"    # Landroid/os/Parcel;
    .param p3, "reply"    # Landroid/os/Parcel;
    .param p4, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    .line 60
    sparse-switch p1, :sswitch_data_0

    .line 79
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v3

    :goto_0
    return v3

    .line 63
    :sswitch_0
    const-string/jumbo v4, "android.content.pm.IPackageDeleteObserver"

    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 67
    :sswitch_1
    const-string/jumbo v4, "android.content.pm.IPackageDeleteObserver"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 68
    invoke-direct {p0}, Landroid/content/pm/IPackageDeleteObserver$Stub;->isPreIceCreamSandwich()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 69
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_0

    move v2, v3

    .line 70
    .local v2, "success":Z
    :goto_1
    invoke-virtual {p0, v2}, Landroid/content/pm/IPackageDeleteObserver$Stub;->packageDeleted(Z)V

    goto :goto_0

    .line 69
    .end local v2    # "success":Z
    :cond_0
    const/4 v2, 0x0

    goto :goto_1

    .line 72
    :cond_1
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 73
    .local v0, "packageName":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 74
    .local v1, "returnCode":I
    invoke-virtual {p0, v0, v1}, Landroid/content/pm/IPackageDeleteObserver$Stub;->packageDeleted(Ljava/lang/String;I)V

    goto :goto_0

    .line 60
    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_1
        0x5f4e5446 -> :sswitch_0
    .end sparse-switch
.end method
