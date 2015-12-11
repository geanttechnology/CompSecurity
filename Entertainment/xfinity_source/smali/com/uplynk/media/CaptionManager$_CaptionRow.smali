.class Lcom/uplynk/media/CaptionManager$_CaptionRow;
.super Ljava/lang/Object;
.source "CaptionManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/CaptionManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "_CaptionRow"
.end annotation


# static fields
.field private static final ROW_LENGTH:I = 0x20


# instance fields
.field private _row:I

.field private characterPosition:S

.field private characters:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/uplynk/media/CaptionManager$_CaptionCharacter;",
            ">;"
        }
    .end annotation
.end field

.field color:I

.field private endPos:S

.field isItalic:Z

.field isUnderlined:Z

.field private startPos:S

.field final synthetic this$0:Lcom/uplynk/media/CaptionManager;


# direct methods
.method protected constructor <init>(Lcom/uplynk/media/CaptionManager;I)V
    .locals 4
    .param p2, "row"    # I

    .prologue
    const/16 v3, 0x20

    const/4 v2, 0x0

    .line 973
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->this$0:Lcom/uplynk/media/CaptionManager;

    .line 972
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 962
    iput v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->_row:I

    .line 968
    iput-boolean v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->isItalic:Z

    .line 969
    iput-boolean v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->isUnderlined:Z

    .line 970
    const v1, 0xffffff

    iput v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->color:I

    .line 974
    iput p2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->_row:I

    .line 975
    iput-boolean v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->isItalic:Z

    .line 976
    iput-boolean v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->isUnderlined:Z

    .line 977
    const v1, 0xfffffff

    iput v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->color:I

    .line 978
    iput-short v3, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    .line 979
    const/4 v1, -0x1

    iput-short v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->endPos:S

    .line 980
    iput-short v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    .line 981
    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1, v3}, Ljava/util/Vector;-><init>(I)V

    iput-object v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characters:Ljava/util/Vector;

    .line 984
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-lt v0, v3, :cond_0

    .line 990
    return-void

    .line 986
    :cond_0
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characters:Ljava/util/Vector;

    new-instance v2, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;

    invoke-direct {v2, p1}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;-><init>(Lcom/uplynk/media/CaptionManager;)V

    invoke-virtual {v1, v0, v2}, Ljava/util/Vector;->add(ILjava/lang/Object;)V

    .line 984
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method private incrementPosition(I)V
    .locals 2
    .param p1, "amount"    # I

    .prologue
    .line 994
    iget-short v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    add-int/2addr v0, p1

    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characters:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 995
    iget-short v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    add-int/2addr v0, p1

    int-to-short v0, v0

    iput-short v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    .line 999
    :goto_0
    return-void

    .line 997
    :cond_0
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characters:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    int-to-short v0, v0

    iput-short v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    goto :goto_0
.end method


# virtual methods
.method backspace()V
    .locals 2

    .prologue
    .line 1003
    iget-short v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    if-lez v0, :cond_0

    .line 1004
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characters:Ljava/util/Vector;

    iget-short v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    invoke-virtual {v0, v1}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->reset()V

    .line 1005
    iget-short v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    add-int/lit8 v0, v0, -0x1

    int-to-short v0, v0

    iput-short v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    .line 1007
    :cond_0
    return-void
.end method

.method clearToEnd()V
    .locals 2

    .prologue
    .line 1011
    iget-short v0, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characters:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->size()I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 1015
    return-void

    .line 1013
    :cond_0
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characters:Ljava/util/Vector;

    invoke-virtual {v1, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->reset()V

    .line 1011
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method getData()[S
    .locals 13

    .prologue
    const/4 v12, 0x2

    const/4 v11, 0x0

    const/4 v10, 0x1

    .line 1094
    iget-short v6, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->endPos:S

    iget-short v7, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    sub-int/2addr v6, v7

    add-int/lit8 v6, v6, 0x1

    int-to-short v4, v6

    .line 1096
    .local v4, "size":S
    const/4 v3, 0x0

    .line 1098
    .local v3, "pos":S
    add-int/lit8 v6, v4, 0x4

    if-gez v6, :cond_0

    .line 1100
    const-string v6, "upLynkCaptionManager"

    const-string v7, "Invalid CC Row Data Size: %d vs %d"

    new-array v8, v12, [Ljava/lang/Object;

    iget-short v9, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    invoke-static {v9}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v9

    aput-object v9, v8, v11

    iget-short v9, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->endPos:S

    invoke-static {v9}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1101
    const/4 v4, 0x0

    .line 1102
    invoke-virtual {p0}, Lcom/uplynk/media/CaptionManager$_CaptionRow;->reset()V

    .line 1105
    :cond_0
    add-int/lit8 v6, v4, 0x4

    new-array v1, v6, [S

    .line 1107
    .local v1, "data":[S
    iget v6, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->_row:I

    int-to-short v6, v6

    aput-short v6, v1, v11

    int-to-short v3, v10

    .line 1108
    iget-short v6, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    aput-short v6, v1, v10

    add-int/lit8 v6, v3, 0x1

    int-to-short v3, v6

    .line 1109
    iget-short v6, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    aput-short v6, v1, v12

    add-int/lit8 v6, v3, 0x1

    int-to-short v3, v6

    .line 1110
    const/4 v6, 0x3

    aput-short v4, v1, v6

    add-int/lit8 v6, v3, 0x1

    int-to-short v3, v6

    .line 1112
    iget-short v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    .local v2, "i":I
    :goto_0
    iget-short v6, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->endPos:S

    if-le v2, v6, :cond_1

    .line 1122
    return-object v1

    .line 1114
    :cond_1
    iget-object v6, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characters:Ljava/util/Vector;

    invoke-virtual {v6, v2}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;

    .line 1115
    .local v0, "c":Lcom/uplynk/media/CaptionManager$_CaptionCharacter;
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->character()S

    move-result v5

    .line 1117
    .local v5, "t":S
    aput-short v5, v1, v3

    add-int/lit8 v6, v3, 0x1

    int-to-short v3, v6

    .line 1112
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method getMarkup()Ljava/lang/String;
    .locals 13

    .prologue
    .line 1128
    new-instance v6, Ljava/lang/StringBuffer;

    invoke-direct {v6}, Ljava/lang/StringBuffer;-><init>()V

    .line 1132
    .local v6, "sb":Ljava/lang/StringBuffer;
    iget-short v8, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->endPos:S

    iget-short v9, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    sub-int/2addr v8, v9

    add-int/lit8 v8, v8, 0x1

    int-to-short v7, v8

    .line 1136
    .local v7, "size":S
    add-int/lit8 v8, v7, 0x4

    if-gez v8, :cond_0

    .line 1138
    const-string v8, "upLynkCaptionManager"

    const-string v9, "Invalid CC Row Data Size: %d vs %d"

    const/4 v10, 0x2

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    iget-short v12, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    invoke-static {v12}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x1

    iget-short v12, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->endPos:S

    invoke-static {v12}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1139
    const/4 v7, 0x0

    .line 1140
    invoke-virtual {p0}, Lcom/uplynk/media/CaptionManager$_CaptionRow;->reset()V

    .line 1144
    :cond_0
    const v1, 0xffffff

    .line 1145
    .local v1, "color":I
    const/4 v3, 0x0

    .line 1146
    .local v3, "isItalic":Z
    const/4 v5, 0x0

    .line 1147
    .local v5, "isUnderlined":Z
    const/4 v4, 0x0

    .line 1155
    .local v4, "isTransparent":Z
    iget-short v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    .local v2, "i":I
    :goto_0
    iget-short v8, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->endPos:S

    if-le v2, v8, :cond_3

    .line 1183
    if-eqz v5, :cond_1

    const-string v8, "</u>"

    invoke-virtual {v6, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1184
    :cond_1
    if-eqz v3, :cond_2

    const-string v8, "</em>"

    invoke-virtual {v6, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1186
    :cond_2
    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v8

    return-object v8

    .line 1157
    :cond_3
    iget-object v8, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characters:Ljava/util/Vector;

    invoke-virtual {v8, v2}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;

    .line 1158
    .local v0, "c":Lcom/uplynk/media/CaptionManager$_CaptionCharacter;
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->isItalic()Z

    move-result v8

    if-eq v8, v3, :cond_4

    .line 1160
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->isItalic()Z

    move-result v8

    if-eqz v8, :cond_8

    const-string v8, "<em>"

    :goto_1
    invoke-virtual {v6, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1161
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->isItalic()Z

    move-result v3

    .line 1164
    :cond_4
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->isUnderlined()Z

    move-result v8

    if-eq v8, v5, :cond_5

    .line 1166
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->isUnderlined()Z

    move-result v8

    if-eqz v8, :cond_9

    const-string v8, "<u>"

    :goto_2
    invoke-virtual {v6, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1167
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->isUnderlined()Z

    move-result v5

    .line 1170
    :cond_5
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->isTransparent()Z

    move-result v8

    if-eq v8, v4, :cond_6

    .line 1172
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->isTransparent()Z

    move-result v4

    .line 1175
    :cond_6
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->color()I

    move-result v8

    if-eq v8, v1, :cond_7

    .line 1177
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->color()I

    move-result v1

    .line 1180
    :cond_7
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->character()S

    move-result v8

    int-to-char v8, v8

    invoke-virtual {v6, v8}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 1155
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 1160
    :cond_8
    const-string v8, "</em>"

    goto :goto_1

    .line 1166
    :cond_9
    const-string v8, "</u>"

    goto :goto_2
.end method

.method getText()Ljava/lang/String;
    .locals 11

    .prologue
    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 1074
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    .line 1077
    .local v3, "sb":Ljava/lang/StringBuffer;
    const-string v4, "upLynkCaptionManager"

    const-string v5, "Get Row Characters 0-%d {%d,%d}"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    iget-short v7, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    invoke-static {v7}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v7

    aput-object v7, v6, v8

    iget-short v7, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    invoke-static {v7}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v7

    aput-object v7, v6, v9

    iget-short v7, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->endPos:S

    invoke-static {v7}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v7

    aput-object v7, v6, v10

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1078
    iget-short v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    .local v2, "i":I
    :goto_0
    iget-short v4, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->endPos:S

    if-le v2, v4, :cond_0

    .line 1086
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4

    .line 1080
    :cond_0
    iget-object v4, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characters:Ljava/util/Vector;

    invoke-virtual {v4, v2}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;

    .line 1081
    .local v0, "c":Lcom/uplynk/media/CaptionManager$_CaptionCharacter;
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->character()S

    move-result v4

    int-to-char v1, v4

    .line 1082
    .local v1, "ch":C
    const-string v4, "upLynkCaptionManager"

    const-string v5, "CC [%d] %c"

    new-array v6, v10, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-static {v1}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1083
    invoke-virtual {v3, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 1078
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method reset()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1195
    iput-boolean v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->isItalic:Z

    .line 1196
    iput-boolean v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->isUnderlined:Z

    .line 1197
    const v1, 0xffffff

    iput v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->color:I

    .line 1199
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characters:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/uplynk/media/CaptionManager$_CaptionCharacter;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-nez v1, :cond_0

    .line 1204
    iput-short v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    .line 1205
    const/16 v1, 0x20

    iput-short v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    .line 1206
    const/4 v1, -0x1

    iput-short v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->endPos:S

    .line 1207
    return-void

    .line 1201
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;

    invoke-virtual {v1}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->reset()V

    goto :goto_0
.end method

.method setColumnIndex(S)V
    .locals 0
    .param p1, "value"    # S

    .prologue
    .line 1046
    iput-short p1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    .line 1047
    return-void
.end method

.method tabIndex(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 1051
    invoke-direct {p0, p1}, Lcom/uplynk/media/CaptionManager$_CaptionRow;->incrementPosition(I)V

    .line 1052
    return-void
.end method

.method toCaptionRow(Lcom/uplynk/media/CaptionEvent;)Lcom/uplynk/media/CaptionEvent$CaptionRow;
    .locals 11
    .param p1, "event"    # Lcom/uplynk/media/CaptionEvent;

    .prologue
    .line 1056
    new-instance v9, Ljava/lang/StringBuffer;

    invoke-direct {v9}, Ljava/lang/StringBuffer;-><init>()V

    .line 1058
    .local v9, "line":Ljava/lang/StringBuffer;
    new-instance v6, Ljava/util/Vector;

    invoke-direct {v6}, Ljava/util/Vector;-><init>()V

    .line 1059
    .local v6, "vc":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    iget-short v8, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    .local v8, "i":I
    :goto_0
    iget-short v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->endPos:S

    if-le v8, v1, :cond_0

    .line 1067
    new-instance v0, Lcom/uplynk/media/CaptionEvent$CaptionRow;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->_row:I

    iget-short v3, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    iget-short v4, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    invoke-virtual {v9}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    move-object v1, p1

    invoke-direct/range {v0 .. v6}, Lcom/uplynk/media/CaptionEvent$CaptionRow;-><init>(Lcom/uplynk/media/CaptionEvent;IIILjava/lang/String;Ljava/util/Vector;)V

    .line 1069
    .local v0, "r":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    return-object v0

    .line 1061
    .end local v0    # "r":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    :cond_0
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characters:Ljava/util/Vector;

    invoke-virtual {v1, v8}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;

    .line 1062
    .local v7, "c":Lcom/uplynk/media/CaptionManager$_CaptionCharacter;
    invoke-virtual {v7}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->character()S

    move-result v10

    .line 1063
    .local v10, "t":S
    int-to-char v1, v10

    invoke-virtual {v9, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 1064
    invoke-virtual {v7, p1}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->toCaptionCharacter(Lcom/uplynk/media/CaptionEvent;)Lcom/uplynk/media/CaptionEvent$CaptionCharacter;

    move-result-object v1

    invoke-virtual {v6, v1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 1059
    add-int/lit8 v8, v8, 0x1

    goto :goto_0
.end method

.method writeChar(C)V
    .locals 6
    .param p1, "value"    # C

    .prologue
    const/4 v5, 0x1

    .line 1020
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characters:Ljava/util/Vector;

    iget-short v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    invoke-virtual {v1, v2}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;

    .line 1022
    .local v0, "c":Lcom/uplynk/media/CaptionManager$_CaptionCharacter;
    if-nez v0, :cond_0

    .line 1024
    const-string v1, "upLynkCaptionManager"

    const-string v2, "Invalid CC Character Position: %d"

    new-array v3, v5, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-short v5, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    invoke-static {v5}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1042
    :goto_0
    return-void

    .line 1029
    :cond_0
    int-to-short v1, p1

    iget v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->color:I

    iget-boolean v3, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->isItalic:Z

    iget-boolean v4, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->isUnderlined:Z

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/uplynk/media/CaptionManager$_CaptionCharacter;->setValue(SIZZ)V

    .line 1031
    iget-short v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    iget-short v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    if-ge v1, v2, :cond_1

    .line 1032
    iget-short v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    iput-short v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->startPos:S

    .line 1035
    :cond_1
    iget-short v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    iget-short v2, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->endPos:S

    if-le v1, v2, :cond_2

    .line 1036
    iget-short v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->characterPosition:S

    iput-short v1, p0, Lcom/uplynk/media/CaptionManager$_CaptionRow;->endPos:S

    .line 1041
    :cond_2
    invoke-direct {p0, v5}, Lcom/uplynk/media/CaptionManager$_CaptionRow;->incrementPosition(I)V

    goto :goto_0
.end method
