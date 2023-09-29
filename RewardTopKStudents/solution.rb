# @param {String[]} positive_feedback
# @param {String[]} negative_feedback
# @param {String[]} report
# @param {Integer[]} student_id
# @param {Integer} k
# @return {Integer[]}
def top_students(positive_feedback, negative_feedback, report, student_ids, k)
    students_points = []
    positive_feedback = positive_feedback.to_h{|w| [w, true]}
    negative_feedback = negative_feedback.to_h{|w| [w, true]}

    student_ids.each_with_index do |student_id, index|
        points = points_for(positive_feedback, negative_feedback, report, index)
        students_points << [student_id, points]
    end

    students_points.sort! do |prev, n|
        if (prev[1] > n[1])
            points_comparison = -1;
        elsif (prev[1] < n[1])
            points_comparison = 1
        elsif (prev[1] == n[1])
            if (prev[0] > n[0])
                points_comparison = 1;
            elsif (prev[0] < n[0])
                points_comparison = -1
            else
                points_comparison = 0
            end
        end

        points_comparison
    end

    students_points[0...k].map{|st| st[0]}
end

def points_for(positive_feedback, negative_feedback, report, student_idx)
    student_feedback = report[student_idx].split
    points = 0

    student_feedback.each do |fb|
        points += 3 if positive_feedback[fb]
        points -= 1 if negative_feedback[fb]
    end

    points
end

arr = []
