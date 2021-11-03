
import java.util.Scanner;

public class MyMatch extends Match {
	private Position m;

	public MyMatch() {
		super();
	}

	public boolean getCheckWinningCondition(Position m) {
		boolean checkWinning = checkWinningCondition(m);

		return checkWinning;
	}

	public boolean getCheckValidity(Position m) {
		boolean checkVal = checkValidity(m);

		return checkVal;
	}

	//////////// 게임 관련 메소드 ////////////
	public void resisterPlayer() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		int userID = -1, userOrder = -1;
		String userName = "";

		System.out.print("<게임 타입> 1. 사용자vs사용자, 2. 사용자vs컴퓨터 : ");
		int gameType = s.nextInt();

		switch (gameType) {
		case 1:
			System.out.println("<플레이어 입력 - 사용자 1>");
			System.out.print("ID : ");
			userID = s.nextInt();
			System.out.print("이름 : ");
			userName = s.next();
			System.out.print("순서(1,2) : ");
			userOrder = s.nextInt();

			Player p1 = new Player(userID, userName, userOrder, 1) {
				@Override
				public Position play(OmokBoard board) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			setPlayer(0, p1);

			System.out.println("<플레이어 입력 - 사용자 2>");
			System.out.print("ID : ");
			userID = s.nextInt();
			for (int i = 0; i < 2; i++) {
				if (p1.getID() == userID) {
					System.out.println("ID 중복.");
					return;
				}
			}
			System.out.print("이름 : ");
			userName = s.next();
			// 순서 결정
			if (p1.getOrder() == 1) {
				System.out.println("자동으로 2번째 순서로 설정됩니다.");
				userOrder = 2;
			} else if (p1.getOrder() == 2) {
				System.out.println("자동으로 1번째 순서로 설정됩니다.");
				userOrder = 1;
			}

			Player p2 = new Player(userID, userName, userOrder, 1) {
				@Override
				public Position play(OmokBoard board) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			setPlayer(1, p2);

			System.out.println("플레이어 설정 완료!");
			break;

		case 2:
			System.out.println("<플레이어 입력 - 사용자>");
			System.out.print("ID : ");
			userID = s.nextInt();
			System.out.print("이름 : ");
			userName = s.next();
			System.out.print("순서(1,2) : ");
			userOrder = s.nextInt();

			Player p = new Player(userID, userName, userOrder, 1) {
				@Override
				public Position play(OmokBoard board) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			setPlayer(0, p);

			// 컴퓨터 순서 결정
			if (p.getOrder() == 1)
				userOrder = 2;
			else if (p.getOrder() == 2)
				userOrder = 1;

			Player com = new ComputerPlayer(-10000, "COMPUTER", userOrder, 2);
			setPlayer(1, com);

			System.out.println("플레이어 설정 완료!");
			break;

		default:
			System.out.println("입력 오류");
			break;
		}
	}

	public void gameStart() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		// 오목판 생성
		if (players[0] == null || players[1] == null) {
			System.out.println("플레이어를 입력해주세요.");
			return;
		}

		System.out.print("오목판 크기 (0:10x10, 1:15x15, 2:19x19) : ");
		int userBoardSize = s.nextInt();

		OmokBoard temp = new MyBoard();
		temp.setBoardSize(userBoardSize);
		setBoard(temp);
		temp.initBoard();

		System.out.println("<오목판 세팅 완료>");

		OmokBoard gameBoard = getBoard();
		gameBoard.display();

		// 사용자끼리의 대결인지, 컴퓨터와의 대결인지 확인
		int gameType = 0;

		if (players[1].getPlayerType() == 1)
			gameType = 1;
		else {
			// 컴퓨터와의 대결이라면, 누가 선인지 순서 확인
			if (players[1].getOrder() == 1) // 컴퓨터가 선
				gameType = 2;
			else
				gameType = 3; // 사용자가 선
		}

		switch (gameType) {
		case 1:
			System.out.println("첫번째 순서:흑돌, 두번째 순서:백돌으로 자동 설정됩니다.");

			while (true) {
				int firstPlayer = 0;
				int secondPlayer = 0;
				boolean win = false;

				for (int i = 0; i < 2; i++) {
					if (players[i].getOrder() == 1)
						firstPlayer = i;
					else if (players[i].getOrder() == 2)
						secondPlayer = i;
				}

				// 1번 플레이어 순서
				setTurn(1);
				System.out.println(
						"<흑> " + players[firstPlayer].getID() + "(" + players[firstPlayer].getName() + ") 님의 순서입니다.");

				while (true) {
					int userRow = 0;
					int userCol = 0;

					System.out.print("행 : ");
					userRow = s.nextInt();
					System.out.print("열 : ");
					userCol = s.nextInt();
					m = new Position(userRow - 1, userCol - 1);

					if (getCheckValidity(m) == true) {
						gameBoard.putStone(userRow - 1, userCol - 1, StoneType.Black);
						win = getCheckWinningCondition(m);
						break;
					} else {
						System.out.println("이미 돌이 있습니다.");
					}
				}

				gameBoard.display();

				if (win == true) {
					System.out.println("<흑 승리>");
					break;
				}

				// 2번 플레이어 순서
				setTurn(2);
				System.out.println(
						"<백> " + players[secondPlayer].getID() + "(" + players[secondPlayer].getName() + ") 님의 순서입니다.");

				while (true) {
					int userRow = 0;
					int userCol = 0;

					System.out.print("행 : ");
					userRow = s.nextInt();
					System.out.print("열 : ");
					userCol = s.nextInt();
					m = new Position(userRow - 1, userCol - 1);

					if (getCheckValidity(m) == true) {
						gameBoard.putStone(userRow - 1, userCol - 1, StoneType.White);
						win = getCheckWinningCondition(m);
						break;
					} else {
						System.out.println("이미 돌이 있습니다.");
					}
				}

				gameBoard.display();

				if (win == true) {
					System.out.println("<백 승리>");
					break;
				}
			}
			break;

		case 2:
			// 컴퓨터가 선
			System.out.println("사용자:흑돌, 컴퓨터:백돌으로 자동 설정됩니다.");

			while (true) {
				boolean win = false;

				// 컴퓨터
				setTurn(2);
				System.out.println("<백> 컴퓨터의 순서입니다.");

				m = players[1].play(gameBoard);

				gameBoard.putStone(m.getRow(), m.getColumn(), StoneType.White);
				win = getCheckWinningCondition(m);

				gameBoard.display();

				int comRow = m.getRow() + 1;
				int comCol = m.getColumn() + 1;
				System.out.println("<백> 컴퓨터 : " + comRow + "행 " + comCol + "열에 착수");

				if (win == true) {
					System.out.println("<컴퓨터 승리>");
					break;
				}

				// 사용자
				setTurn(1);
				System.out.println("<흑> " + players[0].getID() + "(" + players[0].getName() + ") 님의 순서입니다.");

				while (true) {
					int userRow = 0;
					int userCol = 0;

					System.out.print("행 : ");
					userRow = s.nextInt();
					System.out.print("열 : ");
					userCol = s.nextInt();
					m = new Position(userRow - 1, userCol - 1);

					if (getCheckValidity(m) == true) {
						gameBoard.putStone(userRow - 1, userCol - 1, StoneType.Black);
						win = getCheckWinningCondition(m);
						break;
					} else {
						System.out.println("이미 돌이 있습니다.");
					}
				}

				gameBoard.display();

				if (win == true) {
					System.out.println("<" + players[0].getID() + "(" + players[0].getName() + ") 승리>");
					break;
				}
			}
			break;

		case 3:
			// 사용자가 선
			System.out.println("사용자:흑돌, 컴퓨터:백돌으로 자동 설정됩니다.");

			while (true) {
				boolean win = false;

				// 사용자
				setTurn(1);
				System.out.println("<흑> " + players[0].getID() + "(" + players[0].getName() + ") 님의 순서입니다.");

				while (true) {
					int userRow = 0;
					int userCol = 0;

					System.out.print("행 : ");
					userRow = s.nextInt();
					System.out.print("열 : ");
					userCol = s.nextInt();
					m = new Position(userRow - 1, userCol - 1);

					if (getCheckValidity(m) == true) {
						gameBoard.putStone(userRow - 1, userCol - 1, StoneType.Black);
						win = getCheckWinningCondition(m);
						break;
					} else {
						System.out.println("이미 돌이 있습니다.");
					}
				}

				gameBoard.display();

				if (win == true) {
					System.out.println("<" + players[0].getID() + "(" + players[0].getName() + ") 승리>");
					break;
				}

				// 컴퓨터
				setTurn(2);
				System.out.println("<백> 컴퓨터의 순서입니다.");

				m = players[1].play(gameBoard);

				gameBoard.putStone(m.getRow(), m.getColumn(), StoneType.White);
				win = getCheckWinningCondition(m);

				gameBoard.display();

				int comRow = m.getRow() + 1;
				int comCol = m.getColumn() + 1;
				System.out.println("<백> 컴퓨터 : " + comRow + "행 " + comCol + "열에 착수");

				if (win == true) {
					System.out.println("<컴퓨터 승리>");
					break;
				}
			}
			break;

		default:
			break;
		}
	}
}