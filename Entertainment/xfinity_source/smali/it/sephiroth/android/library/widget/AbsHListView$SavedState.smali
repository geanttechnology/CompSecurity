.class Lit/sephiroth/android/library/widget/AbsHListView$SavedState;
.super Landroid/view/View$BaseSavedState;
.source "AbsHListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lit/sephiroth/android/library/widget/AbsHListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "SavedState"
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lit/sephiroth/android/library/widget/AbsHListView$SavedState;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field checkIdState:Landroid/support/v4/util/LongSparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/LongSparseArray",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field checkState:Landroid/support/v4/util/SparseArrayCompat;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/SparseArrayCompat",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field checkedItemCount:I

.field filter:Ljava/lang/String;

.field firstId:J

.field inActionMode:Z

.field position:I

.field selectedId:J

.field viewLeft:I

.field width:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 1443
    new-instance v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState$1;

    invoke-direct {v0}, Lit/sephiroth/android/library/widget/AbsHListView$SavedState$1;-><init>()V

    sput-object v0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 1313
    invoke-direct {p0, p1}, Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;)V

    .line 1314
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->selectedId:J

    .line 1315
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->firstId:J

    .line 1316
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->viewLeft:I

    .line 1317
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->position:I

    .line 1318
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->width:I

    .line 1319
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->filter:Ljava/lang/String;

    .line 1320
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->inActionMode:Z

    .line 1321
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkedItemCount:I

    .line 1322
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->readSparseBooleanArray(Landroid/os/Parcel;)Landroid/support/v4/util/SparseArrayCompat;

    move-result-object v0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkState:Landroid/support/v4/util/SparseArrayCompat;

    .line 1323
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->readSparseLongArray(Landroid/os/Parcel;)Landroid/support/v4/util/LongSparseArray;

    move-result-object v0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkIdState:Landroid/support/v4/util/LongSparseArray;

    .line 1324
    return-void

    .line 1320
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lit/sephiroth/android/library/widget/AbsHListView$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Lit/sephiroth/android/library/widget/AbsHListView$1;

    .prologue
    .line 1289
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method constructor <init>(Landroid/os/Parcelable;)V
    .locals 0
    .param p1, "superState"    # Landroid/os/Parcelable;

    .prologue
    .line 1306
    invoke-direct {p0, p1}, Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V

    .line 1307
    return-void
.end method

.method private readSparseBooleanArray(Landroid/os/Parcel;)Landroid/support/v4/util/SparseArrayCompat;
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Parcel;",
            ")",
            "Landroid/support/v4/util/SparseArrayCompat",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1343
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 1344
    .local v0, "N":I
    if-gez v0, :cond_0

    .line 1345
    const/4 v1, 0x0

    .line 1349
    :goto_0
    return-object v1

    .line 1347
    :cond_0
    new-instance v1, Landroid/support/v4/util/SparseArrayCompat;

    invoke-direct {v1, v0}, Landroid/support/v4/util/SparseArrayCompat;-><init>(I)V

    .line 1348
    .local v1, "sa":Landroid/support/v4/util/SparseArrayCompat;, "Landroid/support/v4/util/SparseArrayCompat<Ljava/lang/Boolean;>;"
    invoke-direct {p0, v1, p1, v0}, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->readSparseBooleanArrayInternal(Landroid/support/v4/util/SparseArrayCompat;Landroid/os/Parcel;I)V

    goto :goto_0
.end method

.method private readSparseBooleanArrayInternal(Landroid/support/v4/util/SparseArrayCompat;Landroid/os/Parcel;I)V
    .locals 4
    .param p2, "in"    # Landroid/os/Parcel;
    .param p3, "N"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/util/SparseArrayCompat",
            "<",
            "Ljava/lang/Boolean;",
            ">;",
            "Landroid/os/Parcel;",
            "I)V"
        }
    .end annotation

    .prologue
    .local p1, "outVal":Landroid/support/v4/util/SparseArrayCompat;, "Landroid/support/v4/util/SparseArrayCompat<Ljava/lang/Boolean;>;"
    const/4 v2, 0x1

    .line 1365
    :goto_0
    if-lez p3, :cond_1

    .line 1366
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 1367
    .local v0, "key":I
    invoke-virtual {p2}, Landroid/os/Parcel;->readByte()B

    move-result v3

    if-ne v3, v2, :cond_0

    move v1, v2

    .line 1371
    .local v1, "value":Z
    :goto_1
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {p1, v0, v3}, Landroid/support/v4/util/SparseArrayCompat;->append(ILjava/lang/Object;)V

    .line 1372
    add-int/lit8 p3, p3, -0x1

    .line 1373
    goto :goto_0

    .line 1367
    .end local v1    # "value":Z
    :cond_0
    const/4 v1, 0x0

    goto :goto_1

    .line 1374
    .end local v0    # "key":I
    :cond_1
    return-void
.end method

.method private readSparseLongArray(Landroid/os/Parcel;)Landroid/support/v4/util/LongSparseArray;
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Parcel;",
            ")",
            "Landroid/support/v4/util/LongSparseArray",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1330
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 1331
    .local v0, "N":I
    if-gtz v0, :cond_0

    .line 1332
    const/4 v1, 0x0

    .line 1336
    :goto_0
    return-object v1

    .line 1334
    :cond_0
    new-instance v1, Landroid/support/v4/util/LongSparseArray;

    invoke-direct {v1, v0}, Landroid/support/v4/util/LongSparseArray;-><init>(I)V

    .line 1335
    .local v1, "array":Landroid/support/v4/util/LongSparseArray;, "Landroid/support/v4/util/LongSparseArray<Ljava/lang/Integer;>;"
    invoke-direct {p0, v1, p1, v0}, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->readSparseLongArrayInternal(Landroid/support/v4/util/LongSparseArray;Landroid/os/Parcel;I)V

    goto :goto_0
.end method

.method private readSparseLongArrayInternal(Landroid/support/v4/util/LongSparseArray;Landroid/os/Parcel;I)V
    .locals 4
    .param p2, "in"    # Landroid/os/Parcel;
    .param p3, "N"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/util/LongSparseArray",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Landroid/os/Parcel;",
            "I)V"
        }
    .end annotation

    .prologue
    .line 1353
    .local p1, "outVal":Landroid/support/v4/util/LongSparseArray;, "Landroid/support/v4/util/LongSparseArray<Ljava/lang/Integer;>;"
    :goto_0
    if-lez p3, :cond_0

    .line 1354
    invoke-virtual {p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    .line 1355
    .local v0, "key":J
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 1359
    .local v2, "value":I
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {p1, v0, v1, v3}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 1360
    add-int/lit8 p3, p3, -0x1

    .line 1361
    goto :goto_0

    .line 1362
    .end local v0    # "key":J
    .end local v2    # "value":I
    :cond_0
    return-void
.end method

.method private writeSparseBooleanArray(Landroid/support/v4/util/SparseArrayCompat;Landroid/os/Parcel;)V
    .locals 3
    .param p2, "out"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/util/SparseArrayCompat",
            "<",
            "Ljava/lang/Boolean;",
            ">;",
            "Landroid/os/Parcel;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1392
    .local p1, "val":Landroid/support/v4/util/SparseArrayCompat;, "Landroid/support/v4/util/SparseArrayCompat<Ljava/lang/Boolean;>;"
    if-nez p1, :cond_1

    .line 1393
    const/4 v2, -0x1

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 1404
    :cond_0
    return-void

    .line 1396
    :cond_1
    invoke-virtual {p1}, Landroid/support/v4/util/SparseArrayCompat;->size()I

    move-result v0

    .line 1397
    .local v0, "N":I
    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 1398
    const/4 v1, 0x0

    .line 1399
    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 1400
    invoke-virtual {p1, v1}, Landroid/support/v4/util/SparseArrayCompat;->keyAt(I)I

    move-result v2

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 1401
    invoke-virtual {p1, v1}, Landroid/support/v4/util/SparseArrayCompat;->valueAt(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_2

    const/4 v2, 0x1

    :goto_1
    int-to-byte v2, v2

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->writeByte(B)V

    .line 1402
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1401
    :cond_2
    const/4 v2, 0x0

    goto :goto_1
.end method

.method private writeSparseLongArray(Landroid/support/v4/util/LongSparseArray;Landroid/os/Parcel;)V
    .locals 4
    .param p2, "out"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/util/LongSparseArray",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Landroid/os/Parcel;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1380
    .local p1, "array":Landroid/support/v4/util/LongSparseArray;, "Landroid/support/v4/util/LongSparseArray<Ljava/lang/Integer;>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/support/v4/util/LongSparseArray;->size()I

    move-result v0

    .line 1381
    .local v0, "N":I
    :goto_0
    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 1382
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    if-ge v1, v0, :cond_1

    .line 1383
    invoke-virtual {p1, v1}, Landroid/support/v4/util/LongSparseArray;->keyAt(I)J

    move-result-wide v2

    invoke-virtual {p2, v2, v3}, Landroid/os/Parcel;->writeLong(J)V

    .line 1384
    invoke-virtual {p1, v1}, Landroid/support/v4/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 1382
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 1380
    .end local v0    # "N":I
    .end local v1    # "i":I
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 1386
    .restart local v0    # "N":I
    .restart local v1    # "i":I
    :cond_1
    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 1432
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "AbsListView.SavedState{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " selectedId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->selectedId:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " firstId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->firstId:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " viewLeft="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->viewLeft:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " position="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->position:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " width="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->width:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " filter="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->filter:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " checkState="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkState:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 1411
    invoke-super {p0, p1, p2}, Landroid/view/View$BaseSavedState;->writeToParcel(Landroid/os/Parcel;I)V

    .line 1412
    iget-wide v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->selectedId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 1413
    iget-wide v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->firstId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 1414
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->viewLeft:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 1415
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->position:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 1416
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->width:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 1417
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->filter:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 1418
    iget-boolean v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->inActionMode:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    int-to-byte v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    .line 1419
    iget v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkedItemCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 1426
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkState:Landroid/support/v4/util/SparseArrayCompat;

    invoke-direct {p0, v0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->writeSparseBooleanArray(Landroid/support/v4/util/SparseArrayCompat;Landroid/os/Parcel;)V

    .line 1427
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->checkIdState:Landroid/support/v4/util/LongSparseArray;

    invoke-direct {p0, v0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$SavedState;->writeSparseLongArray(Landroid/support/v4/util/LongSparseArray;Landroid/os/Parcel;)V

    .line 1428
    return-void

    .line 1418
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
