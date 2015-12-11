.class Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;
.super Ljava/lang/Object;
.source "IVirtuosoDownloadQueueCallback.java"

# interfaces
.implements Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Proxy"
.end annotation


# instance fields
.field private mRemote:Landroid/os/IBinder;


# direct methods
.method constructor <init>(Landroid/os/IBinder;)V
    .locals 0
    .param p1, "remote"    # Landroid/os/IBinder;

    .prologue
    .line 252
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 254
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    .line 255
    return-void
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    return-object v0
.end method

.method public collectionsComplete([Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 5
    .param p1, "aCompletedCollections"    # [Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 556
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 557
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 559
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 560
    const/4 v2, 0x0

    invoke-virtual {v0, p1, v2}, Landroid/os/Parcel;->writeTypedArray([Landroid/os/Parcelable;I)V

    .line 561
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/16 v3, 0xe

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 562
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 565
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 566
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 568
    return-void

    .line 564
    :catchall_0
    move-exception v2

    .line 565
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 566
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 567
    throw v2
.end method

.method public collectionsProgressUpdated([Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 5
    .param p1, "aUpdatedCollections"    # [Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 541
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 542
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 544
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 545
    const/4 v2, 0x0

    invoke-virtual {v0, p1, v2}, Landroid/os/Parcel;->writeTypedArray([Landroid/os/Parcelable;I)V

    .line 546
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/16 v3, 0xd

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 547
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 550
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 551
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 553
    return-void

    .line 549
    :catchall_0
    move-exception v2

    .line 550
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 551
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 552
    throw v2
.end method

.method public downloadEngineDidFinishDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 5
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 421
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 422
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 424
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 425
    if-eqz p1, :cond_0

    .line 426
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 427
    const/4 v2, 0x0

    invoke-interface {p1, v0, v2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->writeToParcel(Landroid/os/Parcel;I)V

    .line 432
    :goto_0
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/16 v3, 0x8

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 433
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 436
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 437
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 439
    return-void

    .line 430
    :cond_0
    const/4 v2, 0x0

    :try_start_1
    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 435
    :catchall_0
    move-exception v2

    .line 436
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 437
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 438
    throw v2
.end method

.method public downloadEngineDidFinishDownloadingFileMin(Ljava/lang/String;IDDI)V
    .locals 5
    .param p1, "uuid"    # Ljava/lang/String;
    .param p2, "errorOrdinal"    # I
    .param p3, "expected"    # D
    .param p5, "current"    # D
    .param p7, "fragsComplete"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 307
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 308
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 310
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 311
    invoke-virtual {v0, p1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 312
    invoke-virtual {v0, p2}, Landroid/os/Parcel;->writeInt(I)V

    .line 313
    invoke-virtual {v0, p3, p4}, Landroid/os/Parcel;->writeDouble(D)V

    .line 314
    invoke-virtual {v0, p5, p6}, Landroid/os/Parcel;->writeDouble(D)V

    .line 315
    invoke-virtual {v0, p7}, Landroid/os/Parcel;->writeInt(I)V

    .line 316
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v3, 0x3

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 317
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 320
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 321
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 323
    return-void

    .line 319
    :catchall_0
    move-exception v2

    .line 320
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 321
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 322
    throw v2
.end method

.method public downloadEngineDidStartDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 5
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 369
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 370
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 372
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 373
    if-eqz p1, :cond_0

    .line 374
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 375
    const/4 v2, 0x0

    invoke-interface {p1, v0, v2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->writeToParcel(Landroid/os/Parcel;I)V

    .line 380
    :goto_0
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v3, 0x6

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 381
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 384
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 385
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 387
    return-void

    .line 378
    :cond_0
    const/4 v2, 0x0

    :try_start_1
    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 383
    :catchall_0
    move-exception v2

    .line 384
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 385
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 386
    throw v2
.end method

.method public downloadEngineDidStartDownloadingFileMin(Ljava/lang/String;IDDI)V
    .locals 5
    .param p1, "uuid"    # Ljava/lang/String;
    .param p2, "errorOrdinal"    # I
    .param p3, "expected"    # D
    .param p5, "current"    # D
    .param p7, "fragsComplete"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 269
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 270
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 272
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 273
    invoke-virtual {v0, p1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 274
    invoke-virtual {v0, p2}, Landroid/os/Parcel;->writeInt(I)V

    .line 275
    invoke-virtual {v0, p3, p4}, Landroid/os/Parcel;->writeDouble(D)V

    .line 276
    invoke-virtual {v0, p5, p6}, Landroid/os/Parcel;->writeDouble(D)V

    .line 277
    invoke-virtual {v0, p7}, Landroid/os/Parcel;->writeInt(I)V

    .line 278
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v3, 0x1

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 279
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 282
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 283
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 285
    return-void

    .line 281
    :catchall_0
    move-exception v2

    .line 282
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 283
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 284
    throw v2
.end method

.method public downloadEngineFileWithError(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 5
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 447
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 448
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 450
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 451
    if-eqz p1, :cond_0

    .line 452
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 453
    const/4 v2, 0x0

    invoke-interface {p1, v0, v2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->writeToParcel(Landroid/os/Parcel;I)V

    .line 458
    :goto_0
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/16 v3, 0x9

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 459
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 462
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 463
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 465
    return-void

    .line 456
    :cond_0
    const/4 v2, 0x0

    :try_start_1
    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 461
    :catchall_0
    move-exception v2

    .line 462
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 463
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 464
    throw v2
.end method

.method public downloadEngineFileWithErrorMin(Ljava/lang/String;IDDI)V
    .locals 5
    .param p1, "uuid"    # Ljava/lang/String;
    .param p2, "errorOrdinal"    # I
    .param p3, "expected"    # D
    .param p5, "current"    # D
    .param p7, "fragsComplete"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 326
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 327
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 329
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 330
    invoke-virtual {v0, p1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 331
    invoke-virtual {v0, p2}, Landroid/os/Parcel;->writeInt(I)V

    .line 332
    invoke-virtual {v0, p3, p4}, Landroid/os/Parcel;->writeDouble(D)V

    .line 333
    invoke-virtual {v0, p5, p6}, Landroid/os/Parcel;->writeDouble(D)V

    .line 334
    invoke-virtual {v0, p7}, Landroid/os/Parcel;->writeInt(I)V

    .line 335
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v3, 0x4

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 336
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 339
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 340
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 342
    return-void

    .line 338
    :catchall_0
    move-exception v2

    .line 339
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 340
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 341
    throw v2
.end method

.method public downloadEngineProgressUpdatedForFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 5
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 395
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 396
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 398
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 399
    if-eqz p1, :cond_0

    .line 400
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 401
    const/4 v2, 0x0

    invoke-interface {p1, v0, v2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->writeToParcel(Landroid/os/Parcel;I)V

    .line 406
    :goto_0
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v3, 0x7

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 407
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 410
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 411
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 413
    return-void

    .line 404
    :cond_0
    const/4 v2, 0x0

    :try_start_1
    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 409
    :catchall_0
    move-exception v2

    .line 410
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 411
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 412
    throw v2
.end method

.method public downloadEngineProgressUpdatedForFileMin(Ljava/lang/String;IDDI)V
    .locals 5
    .param p1, "uuid"    # Ljava/lang/String;
    .param p2, "errorOrdinal"    # I
    .param p3, "expected"    # D
    .param p5, "current"    # D
    .param p7, "fragsComplete"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 288
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 289
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 291
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 292
    invoke-virtual {v0, p1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 293
    invoke-virtual {v0, p2}, Landroid/os/Parcel;->writeInt(I)V

    .line 294
    invoke-virtual {v0, p3, p4}, Landroid/os/Parcel;->writeDouble(D)V

    .line 295
    invoke-virtual {v0, p5, p6}, Landroid/os/Parcel;->writeDouble(D)V

    .line 296
    invoke-virtual {v0, p7}, Landroid/os/Parcel;->writeInt(I)V

    .line 297
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 298
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 301
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 302
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 304
    return-void

    .line 300
    :catchall_0
    move-exception v2

    .line 301
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 302
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 303
    throw v2
.end method

.method public engineContentInQueuedList(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;II)V
    .locals 5
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p2, "aOffset"    # I
    .param p3, "aListSize"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 495
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 496
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 498
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 499
    if-eqz p1, :cond_0

    .line 500
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 501
    const/4 v2, 0x0

    invoke-interface {p1, v0, v2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->writeToParcel(Landroid/os/Parcel;I)V

    .line 506
    :goto_0
    invoke-virtual {v0, p2}, Landroid/os/Parcel;->writeInt(I)V

    .line 507
    invoke-virtual {v0, p3}, Landroid/os/Parcel;->writeInt(I)V

    .line 508
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/16 v3, 0xb

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 509
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 512
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 513
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 515
    return-void

    .line 504
    :cond_0
    const/4 v2, 0x0

    :try_start_1
    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 511
    :catchall_0
    move-exception v2

    .line 512
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 513
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 514
    throw v2
.end method

.method public engineDownloadQueueChanged()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 524
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 525
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 527
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 528
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/16 v3, 0xc

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 529
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 532
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 533
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 535
    return-void

    .line 531
    :catchall_0
    move-exception v2

    .line 532
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 533
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 534
    throw v2
.end method

.method public fragmentComplete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 5
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 468
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 469
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 471
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 472
    if-eqz p1, :cond_0

    .line 473
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 474
    const/4 v2, 0x0

    invoke-interface {p1, v0, v2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->writeToParcel(Landroid/os/Parcel;I)V

    .line 479
    :goto_0
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/16 v3, 0xa

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 480
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 483
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 484
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 486
    return-void

    .line 477
    :cond_0
    const/4 v2, 0x0

    :try_start_1
    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 482
    :catchall_0
    move-exception v2

    .line 483
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 484
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 485
    throw v2
.end method

.method public fragmentCompleteMin(Ljava/lang/String;IDDI)V
    .locals 5
    .param p1, "uuid"    # Ljava/lang/String;
    .param p2, "errorOrdinal"    # I
    .param p3, "expected"    # D
    .param p5, "current"    # D
    .param p7, "fragsComplete"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 345
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 346
    .local v0, "_data":Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 348
    .local v1, "_reply":Landroid/os/Parcel;
    :try_start_0
    const-string v2, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 349
    invoke-virtual {v0, p1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 350
    invoke-virtual {v0, p2}, Landroid/os/Parcel;->writeInt(I)V

    .line 351
    invoke-virtual {v0, p3, p4}, Landroid/os/Parcel;->writeDouble(D)V

    .line 352
    invoke-virtual {v0, p5, p6}, Landroid/os/Parcel;->writeDouble(D)V

    .line 353
    invoke-virtual {v0, p7}, Landroid/os/Parcel;->writeInt(I)V

    .line 354
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v3, 0x5

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 355
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 358
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 359
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 361
    return-void

    .line 357
    :catchall_0
    move-exception v2

    .line 358
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 359
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 360
    throw v2
.end method
