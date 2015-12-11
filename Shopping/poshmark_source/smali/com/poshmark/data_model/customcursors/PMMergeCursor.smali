.class public Lcom/poshmark/data_model/customcursors/PMMergeCursor;
.super Landroid/database/AbstractCursor;
.source "PMMergeCursor.java"


# instance fields
.field private mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

.field private mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

.field private mObserver:Landroid/database/DataSetObserver;


# direct methods
.method public constructor <init>([Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 3
    .param p1, "cursors"    # [Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    .line 34
    invoke-direct {p0}, Landroid/database/AbstractCursor;-><init>()V

    .line 18
    new-instance v1, Lcom/poshmark/data_model/customcursors/PMMergeCursor$1;

    invoke-direct {v1, p0}, Lcom/poshmark/data_model/customcursors/PMMergeCursor$1;-><init>(Lcom/poshmark/data_model/customcursors/PMMergeCursor;)V

    iput-object v1, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mObserver:Landroid/database/DataSetObserver;

    .line 35
    iput-object p1, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 36
    const/4 v1, 0x0

    aget-object v1, p1, v1

    iput-object v1, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 38
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    array-length v1, v1

    if-ge v0, v1, :cond_1

    .line 39
    iget-object v1, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v1, v1, v0

    if-nez v1, :cond_0

    .line 38
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 41
    :cond_0
    iget-object v1, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v1, v1, v0

    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mObserver:Landroid/database/DataSetObserver;

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    goto :goto_1

    .line 43
    :cond_1
    return-void
.end method

.method static synthetic access$002(Lcom/poshmark/data_model/customcursors/PMMergeCursor;I)I
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/data_model/customcursors/PMMergeCursor;
    .param p1, "x1"    # I

    .prologue
    .line 13
    iput p1, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mPos:I

    return p1
.end method

.method static synthetic access$102(Lcom/poshmark/data_model/customcursors/PMMergeCursor;I)I
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/data_model/customcursors/PMMergeCursor;
    .param p1, "x1"    # I

    .prologue
    .line 13
    iput p1, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mPos:I

    return p1
.end method


# virtual methods
.method public close()V
    .locals 3

    .prologue
    .line 163
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    array-length v1, v2

    .line 164
    .local v1, "length":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 165
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v2, v2, v0

    if-nez v2, :cond_0

    .line 164
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 166
    :cond_0
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v2, v2, v0

    invoke-virtual {v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->close()V

    goto :goto_1

    .line 168
    :cond_1
    invoke-super {p0}, Landroid/database/AbstractCursor;->close()V

    .line 169
    return-void
.end method

.method public deactivate()V
    .locals 3

    .prologue
    .line 152
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    array-length v1, v2

    .line 153
    .local v1, "length":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 154
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v2, v2, v0

    if-eqz v2, :cond_0

    .line 155
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v2, v2, v0

    invoke-virtual {v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->deactivate()V

    .line 153
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 158
    :cond_1
    invoke-super {p0}, Landroid/database/AbstractCursor;->deactivate()V

    .line 159
    return-void
.end method

.method public get(I)Ljava/lang/Object;
    .locals 1
    .param p1, "idCol"    # I

    .prologue
    .line 229
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getBlob(I)[B
    .locals 1
    .param p1, "column"    # I

    .prologue
    .line 136
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getBlob(I)[B

    move-result-object v0

    return-object v0
.end method

.method public getColumnNames()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    if-eqz v0, :cond_0

    .line 143
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    invoke-virtual {v0}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnNames()[Ljava/lang/String;

    move-result-object v0

    .line 145
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    goto :goto_0
.end method

.method public getCount()I
    .locals 4

    .prologue
    .line 48
    const/4 v0, 0x0

    .line 49
    .local v0, "count":I
    iget-object v3, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    array-length v2, v3

    .line 50
    .local v2, "length":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_1

    .line 51
    iget-object v3, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v3, v3, v1

    if-eqz v3, :cond_0

    .line 52
    iget-object v3, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v3, v3, v1

    invoke-virtual {v3}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getCount()I

    move-result v3

    add-int/2addr v0, v3

    .line 50
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 55
    :cond_1
    return v0
.end method

.method public getCurrentCursor()Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    return-object v0
.end method

.method public getCursorAtPos(I)Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    .locals 2
    .param p1, "pos"    # I

    .prologue
    .line 245
    iget-object v1, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    array-length v0, v1

    .line 246
    .local v0, "length":I
    if-ge p1, v0, :cond_0

    .line 247
    iget-object v1, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v1, v1, p1

    .line 249
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getDouble(I)D
    .locals 2
    .param p1, "column"    # I

    .prologue
    .line 119
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getDouble(I)D

    move-result-wide v0

    return-wide v0
.end method

.method public getFloat(I)F
    .locals 1
    .param p1, "column"    # I

    .prologue
    .line 113
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getFloat(I)F

    move-result v0

    return v0
.end method

.method public getInt(I)I
    .locals 1
    .param p1, "column"    # I

    .prologue
    .line 101
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getInt(I)I

    move-result v0

    return v0
.end method

.method public getLong(I)J
    .locals 2
    .param p1, "column"    # I

    .prologue
    .line 107
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getLong(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getShort(I)S
    .locals 1
    .param p1, "column"    # I

    .prologue
    .line 95
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getShort(I)S

    move-result v0

    return v0
.end method

.method public getString(I)Ljava/lang/String;
    .locals 1
    .param p1, "column"    # I

    .prologue
    .line 89
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getType(I)I
    .locals 1
    .param p1, "column"    # I

    .prologue
    .line 124
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getType(I)I

    move-result v0

    return v0
.end method

.method public isNull(I)Z
    .locals 1
    .param p1, "column"    # I

    .prologue
    .line 130
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->isNull(I)Z

    move-result v0

    return v0
.end method

.method public onMove(II)Z
    .locals 6
    .param p1, "oldPosition"    # I
    .param p2, "newPosition"    # I

    .prologue
    .line 62
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 63
    const/4 v0, 0x0

    .line 64
    .local v0, "cursorStartPos":I
    iget-object v4, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    array-length v2, v4

    .line 65
    .local v2, "length":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_1

    .line 66
    iget-object v4, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v4, v4, v1

    if-nez v4, :cond_0

    .line 65
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 70
    :cond_0
    iget-object v4, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v4, v4, v1

    invoke-virtual {v4}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getCount()I

    move-result v4

    add-int/2addr v4, v0

    if-ge p2, v4, :cond_2

    .line 71
    iget-object v4, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v4, v4, v1

    iput-object v4, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 79
    :cond_1
    iget-object v4, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    if-eqz v4, :cond_3

    .line 80
    iget-object v4, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    sub-int v5, p2, v0

    invoke-virtual {v4, v5}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->moveToPosition(I)Z

    move-result v3

    .line 83
    :goto_2
    return v3

    .line 75
    :cond_2
    iget-object v4, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v4, v4, v1

    invoke-virtual {v4}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getCount()I

    move-result v4

    add-int/2addr v0, v4

    goto :goto_1

    .line 83
    :cond_3
    const/4 v3, 0x0

    goto :goto_2
.end method

.method public registerContentObserver(Landroid/database/ContentObserver;)V
    .locals 3
    .param p1, "observer"    # Landroid/database/ContentObserver;

    .prologue
    .line 173
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    array-length v1, v2

    .line 174
    .local v1, "length":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 175
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v2, v2, v0

    if-eqz v2, :cond_0

    .line 176
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v2, v2, v0

    invoke-virtual {v2, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->registerContentObserver(Landroid/database/ContentObserver;)V

    .line 174
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 179
    :cond_1
    return-void
.end method

.method public registerDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 3
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 192
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    array-length v1, v2

    .line 193
    .local v1, "length":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 194
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v2, v2, v0

    if-eqz v2, :cond_0

    .line 195
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v2, v2, v0

    invoke-virtual {v2, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 193
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 198
    :cond_1
    return-void
.end method

.method public requery()Z
    .locals 3

    .prologue
    .line 213
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    array-length v1, v2

    .line 214
    .local v1, "length":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_2

    .line 215
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v2, v2, v0

    if-nez v2, :cond_1

    .line 214
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 219
    :cond_1
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v2, v2, v0

    invoke-virtual {v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->requery()Z

    move-result v2

    if-nez v2, :cond_0

    .line 220
    const/4 v2, 0x0

    .line 224
    :goto_1
    return v2

    :cond_2
    const/4 v2, 0x1

    goto :goto_1
.end method

.method public setCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;I)V
    .locals 3
    .param p1, "newCursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    .param p2, "pos"    # I

    .prologue
    .line 233
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    array-length v1, v2

    .line 234
    .local v1, "length":I
    if-ge p2, v1, :cond_0

    .line 235
    invoke-virtual {p0}, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->getPosition()I

    move-result v0

    .line 236
    .local v0, "curPosition":I
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aput-object p1, v2, p2

    .line 237
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursor:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 238
    const/4 v2, -0x1

    iput v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mPos:I

    .line 239
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mObserver:Landroid/database/DataSetObserver;

    invoke-virtual {p1, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 240
    invoke-virtual {p0, v0}, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->move(I)Z

    .line 242
    .end local v0    # "curPosition":I
    :cond_0
    return-void
.end method

.method public unregisterContentObserver(Landroid/database/ContentObserver;)V
    .locals 3
    .param p1, "observer"    # Landroid/database/ContentObserver;

    .prologue
    .line 182
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    array-length v1, v2

    .line 183
    .local v1, "length":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 184
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v2, v2, v0

    if-eqz v2, :cond_0

    .line 185
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v2, v2, v0

    invoke-virtual {v2, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    .line 183
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 188
    :cond_1
    return-void
.end method

.method public unregisterDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 3
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 202
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    array-length v1, v2

    .line 203
    .local v1, "length":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 204
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v2, v2, v0

    if-eqz v2, :cond_0

    .line 205
    iget-object v2, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mCursors:[Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    aget-object v2, v2, v0

    invoke-virtual {v2, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 203
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 208
    :cond_1
    return-void
.end method
