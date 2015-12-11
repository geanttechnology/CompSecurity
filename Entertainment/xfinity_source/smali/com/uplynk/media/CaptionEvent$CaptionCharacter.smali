.class public Lcom/uplynk/media/CaptionEvent$CaptionCharacter;
.super Ljava/lang/Object;
.source "CaptionEvent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/CaptionEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "CaptionCharacter"
.end annotation


# instance fields
.field private _char:S

.field private _color:I

.field private _isItalic:Z

.field private _isTransparent:Z

.field private _isUnderlined:Z

.field final synthetic this$0:Lcom/uplynk/media/CaptionEvent;


# direct methods
.method private constructor <init>(Lcom/uplynk/media/CaptionEvent;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->this$0:Lcom/uplynk/media/CaptionEvent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected constructor <init>(Lcom/uplynk/media/CaptionEvent;SIZZZ)V
    .locals 0
    .param p2, "c"    # S
    .param p3, "color"    # I
    .param p4, "isItalic"    # Z
    .param p5, "isUnderlined"    # Z
    .param p6, "isTransparent"    # Z

    .prologue
    .line 45
    iput-object p1, p0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->this$0:Lcom/uplynk/media/CaptionEvent;

    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-short p2, p0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->_char:S

    .line 47
    iput p3, p0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->_color:I

    .line 48
    iput-boolean p4, p0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->_isItalic:Z

    .line 49
    iput-boolean p5, p0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->_isUnderlined:Z

    .line 50
    iput-boolean p6, p0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->_isTransparent:Z

    .line 52
    return-void
.end method


# virtual methods
.method public character()C
    .locals 1

    .prologue
    .line 54
    iget-short v0, p0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->_char:S

    int-to-char v0, v0

    return v0
.end method

.method public color()I
    .locals 1

    .prologue
    .line 55
    iget v0, p0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->_color:I

    return v0
.end method

.method public isItalic()Z
    .locals 1

    .prologue
    .line 56
    iget-boolean v0, p0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->_isItalic:Z

    return v0
.end method

.method public isUnderlined()Z
    .locals 1

    .prologue
    .line 57
    iget-boolean v0, p0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->_isUnderlined:Z

    return v0
.end method
