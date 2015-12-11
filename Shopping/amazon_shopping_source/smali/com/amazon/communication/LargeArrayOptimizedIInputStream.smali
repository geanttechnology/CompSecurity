.class public Lcom/amazon/communication/LargeArrayOptimizedIInputStream;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/amazon/communication/IInputStream;


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;

.field private static sIsOptimizedReadMethodAvailable:Z

.field private static sOptimizedReadMethod:Ljava/lang/reflect/Method;


# instance fields
.field private final mRemote:Landroid/os/IBinder;

.field private final mStandardImplementation:Lcom/amazon/communication/IInputStream;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const/4 v5, 0x0

    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "TComm.LargeArrayOptimizedIInputStream"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->log:Lcom/amazon/dp/logger/DPLogger;

    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->sOptimizedReadMethod:Ljava/lang/reflect/Method;

    sput-boolean v5, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->sIsOptimizedReadMethodAvailable:Z

    :try_start_0
    const-class v0, Landroid/os/Parcel;

    const-string/jumbo v1, "readByteArray"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    const-class v4, [B

    aput-object v4, v2, v3

    const/4 v3, 0x1

    sget-object v4, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v4, v2, v3

    const/4 v3, 0x2

    sget-object v4, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->sOptimizedReadMethod:Ljava/lang/reflect/Method;

    const/4 v0, 0x1

    sput-boolean v0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->sIsOptimizedReadMethodAvailable:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "static"

    const-string/jumbo v2, "Could not find optimized Parcel.readByteArray(byte[], int, int) method"

    new-array v3, v5, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private constructor <init>(Landroid/os/IBinder;Lcom/amazon/communication/IInputStream;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->mRemote:Landroid/os/IBinder;

    iput-object p2, p0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->mStandardImplementation:Lcom/amazon/communication/IInputStream;

    return-void
.end method

.method protected static isOptimizedReadMethodAvailable()Z
    .locals 1

    sget-boolean v0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->sIsOptimizedReadMethodAvailable:Z

    return v0
.end method

.method public static makeIInputStream(Landroid/os/IBinder;)Lcom/amazon/communication/IInputStream;
    .locals 2

    if-nez p0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "com.amazon.communication.IInputStream"

    invoke-interface {p0, v0}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/amazon/communication/IInputStream;

    if-eqz v1, :cond_1

    check-cast v0, Lcom/amazon/communication/IInputStream;

    goto :goto_0

    :cond_1
    new-instance v0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;

    invoke-static {p0}, Lcom/amazon/communication/IInputStream$Stub;->asInterface(Landroid/os/IBinder;)Lcom/amazon/communication/IInputStream;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;-><init>(Landroid/os/IBinder;Lcom/amazon/communication/IInputStream;)V

    goto :goto_0
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->mStandardImplementation:Lcom/amazon/communication/IInputStream;

    invoke-interface {v0}, Lcom/amazon/communication/IInputStream;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public available()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    iget-object v0, p0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->mStandardImplementation:Lcom/amazon/communication/IInputStream;

    invoke-interface {v0}, Lcom/amazon/communication/IInputStream;->available()I

    move-result v0

    return v0
.end method

.method public close()Z
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    iget-object v0, p0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->mStandardImplementation:Lcom/amazon/communication/IInputStream;

    invoke-interface {v0}, Lcom/amazon/communication/IInputStream;->close()Z

    move-result v0

    return v0
.end method

.method public readByte()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    iget-object v0, p0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->mStandardImplementation:Lcom/amazon/communication/IInputStream;

    invoke-interface {v0}, Lcom/amazon/communication/IInputStream;->readByte()I

    move-result v0

    return v0
.end method

.method public readBytes([B)I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    iget-object v0, p0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->mStandardImplementation:Lcom/amazon/communication/IInputStream;

    invoke-interface {v0, p1}, Lcom/amazon/communication/IInputStream;->readBytes([B)I

    move-result v0

    return v0
.end method

.method public readBytesIntoOffset([BII)I
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v2

    invoke-static {}, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->isOptimizedReadMethodAvailable()Z

    move-result v0

    if-eqz v0, :cond_0

    :try_start_0
    const-string/jumbo v0, "com.amazon.communication.IInputStream"

    invoke-virtual {v1, v0}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    invoke-virtual {v1, p1, p2, p3}, Landroid/os/Parcel;->writeByteArray([BII)V

    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Landroid/os/Parcel;->writeInt(I)V

    invoke-virtual {v1, p3}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->mRemote:Landroid/os/IBinder;

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-interface {v0, v3, v1, v2, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    invoke-virtual {v2}, Landroid/os/Parcel;->readException()V

    invoke-virtual {v2}, Landroid/os/Parcel;->readInt()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    :try_start_1
    sget-object v3, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->sOptimizedReadMethod:Ljava/lang/reflect/Method;

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v3, v2, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    invoke-virtual {v2}, Landroid/os/Parcel;->recycle()V

    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    :goto_0
    return v0

    :catch_0
    move-exception v0

    :try_start_2
    sget-object v3, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "readBytesIntoOffset"

    const-string/jumbo v5, "error invoking bulk read method via reflection"

    const/4 v6, 0x5

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string/jumbo v8, "offset"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x2

    const-string/jumbo v8, "length"

    aput-object v8, v6, v7

    const/4 v7, 0x3

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x4

    aput-object v0, v6, v7

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    new-instance v0, Landroid/os/RemoteException;

    const-string/jumbo v3, "Error invoking optimized read method"

    invoke-direct {v0, v3}, Landroid/os/RemoteException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :catchall_0
    move-exception v0

    invoke-virtual {v2}, Landroid/os/Parcel;->recycle()V

    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->mStandardImplementation:Lcom/amazon/communication/IInputStream;

    invoke-interface {v0, p1, p2, p3}, Lcom/amazon/communication/IInputStream;->readBytesIntoOffset([BII)I

    move-result v0

    goto :goto_0
.end method
