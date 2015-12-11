.class public Lcom/uplynk/media/CaptionEvent$CaptionRow;
.super Ljava/lang/Object;
.source "CaptionEvent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/CaptionEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "CaptionRow"
.end annotation


# instance fields
.field private _characters:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/uplynk/media/CaptionEvent$CaptionCharacter;",
            ">;"
        }
    .end annotation
.end field

.field private _col:I

.field private _indent:I

.field private _row:I

.field private _text:Ljava/lang/String;

.field final synthetic this$0:Lcom/uplynk/media/CaptionEvent;


# direct methods
.method protected constructor <init>(Lcom/uplynk/media/CaptionEvent;)V
    .locals 1

    .prologue
    .line 70
    iput-object p1, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->this$0:Lcom/uplynk/media/CaptionEvent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_characters:Ljava/util/Vector;

    .line 72
    return-void
.end method

.method protected constructor <init>(Lcom/uplynk/media/CaptionEvent;IIILjava/lang/String;)V
    .locals 1
    .param p2, "rowNumber"    # I
    .param p3, "column"    # I
    .param p4, "indent"    # I
    .param p5, "text"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->this$0:Lcom/uplynk/media/CaptionEvent;

    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    iput p2, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_row:I

    .line 77
    iput p3, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_col:I

    .line 78
    iput p4, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_indent:I

    .line 79
    iput-object p5, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_text:Ljava/lang/String;

    .line 80
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_characters:Ljava/util/Vector;

    .line 81
    return-void
.end method

.method protected constructor <init>(Lcom/uplynk/media/CaptionEvent;IIILjava/lang/String;Ljava/util/Vector;)V
    .locals 0
    .param p2, "rowNumber"    # I
    .param p3, "column"    # I
    .param p4, "indent"    # I
    .param p5, "text"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(III",
            "Ljava/lang/String;",
            "Ljava/util/Vector",
            "<",
            "Lcom/uplynk/media/CaptionEvent$CaptionCharacter;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 84
    .local p6, "characters":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    iput-object p1, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->this$0:Lcom/uplynk/media/CaptionEvent;

    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    iput p2, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_row:I

    .line 86
    iput p3, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_col:I

    .line 87
    iput p4, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_indent:I

    .line 88
    iput-object p5, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_text:Ljava/lang/String;

    .line 89
    iput-object p6, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_characters:Ljava/util/Vector;

    .line 90
    return-void
.end method


# virtual methods
.method public final getCharacters()Ljava/util/Vector;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Vector",
            "<",
            "Lcom/uplynk/media/CaptionEvent$CaptionCharacter;",
            ">;"
        }
    .end annotation

    .prologue
    .line 96
    iget-object v0, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_characters:Ljava/util/Vector;

    return-object v0
.end method

.method public getColumn()I
    .locals 1

    .prologue
    .line 93
    iget v0, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_col:I

    return v0
.end method

.method public getIndent()I
    .locals 1

    .prologue
    .line 94
    iget v0, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_indent:I

    return v0
.end method

.method public getRow()I
    .locals 1

    .prologue
    .line 92
    iget v0, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_row:I

    return v0
.end method

.method public getText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/uplynk/media/CaptionEvent$CaptionRow;->_text:Ljava/lang/String;

    return-object v0
.end method
